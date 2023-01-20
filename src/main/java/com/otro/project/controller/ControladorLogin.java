package com.otro.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.otro.project.interfaceService.IusuarioService;
import com.otro.project.modelo.Usuario;

@Controller

public class ControladorLogin {

    @Autowired
    private IusuarioService service;



    @GetMapping ("/login")
    public String login(){
return "login";

    }

     /** FORMULARIO PARA AGREGAR USUARIO */
     
     @GetMapping("/registrar")
     public String agregar(Model model) {
         Usuario usuario = new Usuario();
         model.addAttribute("usuario", usuario);
         return "signup";
 
     }

      /** SALVAR USUARIO */
    @RequestMapping("/saveu")
    public String save(@Validated Usuario u, Model model) {
        try {
            service.save(u);
        } catch (Exception e) {
            model.addAttribute("doble",
            "El correo ( " + u.getCorreo() + " ) ya se encuentra registrado en la base de datos");
            
    return "signup";
        }
        
        model.addAttribute("suc", "Usuario  " + u.getNombre() + " agregado con éxito");
        return "signup";

    }
    }
