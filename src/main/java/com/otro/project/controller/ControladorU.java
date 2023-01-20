package com.otro.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.otro.project.interfaceService.IusuarioService;
import com.otro.project.modelo.Usuario;

@Controller
@RequestMapping
public class ControladorU {

    @Autowired
    private IusuarioService service;

    /** LISTAR USUARIO */
    @GetMapping("/listar_u")
    public String listar(Model model, @Param("palabraClave") String palabraClave) {
        List<Usuario> usuarios = service.listAll(palabraClave);
        if (usuarios.isEmpty() && palabraClave == null) {

            model.addAttribute("vacio", "No hay usuarios en la base de datos");
        }
        if (palabraClave != null && !usuarios.isEmpty()) {
            model.addAttribute("resultados", "Resultados de la búsqueda");
        }
        if (palabraClave != null && usuarios.isEmpty()) {
            model.addAttribute("busquedavacia", "La búsqueda no arrojó resultados");
        }
        model.addAttribute("total", service.total());
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("palabraClave", palabraClave);
        return "listar_u";

    }

    /* ELIMINAR TODOS LOS USUARIOS DE LA BD */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/eliminar_todo")
    public String elimAll() {

        service.truncateMyTable();
        return "/listar_u";
    }

    /** ERROR */
    @GetMapping("/error")
    public String error() {
        return "error";
    }

    /** PAGINA PRINCIPAL */
    @GetMapping(path = { "/", "/principal" })
    public String principal() {

        return "principal";
    }

    /** FORMULARIO PARA AGREGAR USUARIO */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/new")
    public String agregar(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "agregar_u";

    }

    /** SALVAR USUARIO */
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/save")
    public String save(@Validated Usuario u, Model model) {
        var x = service.total();
        try {
            service.save(u);
        } catch (Exception e) {
            model.addAttribute("doble",
                    "El correo ( " + u.getCorreo() + " ) ya se encuentra registrado en la base de datos");

            return "agregar_u";
        }
        if (x < service.total()) {
            model.addAttribute("suc", "Usuario  " + u.getNombre() + " agregado con éxito");
            return "listar_u";
        } else
            model.addAttribute("suc", "Usuario  " + u.getNombre() + " editado con éxito");
        return "listar_u";

    }

    /** ELIMINAR USUARIO */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/eliminar/{id}")
    public String delete(Model model, @PathVariable int id) {

        service.delete(id);
        return "redirect:/listar_u";

    }

    /** EDITAR USUARIO */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {

        Optional<Usuario> usuario = service.listarId(id);

        model.addAttribute("usuario", usuario);

        return "agregar_u";

    }

    @GetMapping("/Cerrar")
    public String transparent() {

        return "transparent";
    }

}