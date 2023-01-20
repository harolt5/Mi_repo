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

import com.otro.project.interfaceService.IproductoService;
import com.otro.project.modelo.Producto;

@Controller
@RequestMapping
public class ControladorP {

    @Autowired
    private IproductoService servicep;

    /** LISTAR PRODUCTOS **/
    @RequestMapping("/listar_p")
    public String listarpro(Model model, @Param("palabraClave") String ppalabraClave) {

        List<Producto> productos = servicep.listAllP(ppalabraClave);
        if (productos.isEmpty() && ppalabraClave == null) {

            model.addAttribute("vacio", "No hay productos en la base de datos");
        }
        if (ppalabraClave != null && !productos.isEmpty()) {
            model.addAttribute("resultados", "Resultados de la búsqueda");
        }
        if (ppalabraClave != null && productos.isEmpty()) {
            model.addAttribute("busquedavacia", "La búsqueda no arrojó resultados");
        }
        model.addAttribute("total", servicep.total());
        model.addAttribute("productos", productos);
        model.addAttribute("ppalabraClave", ppalabraClave);
        return "listar_p";
    }

    /* ELIMINAR TODOS LOS PRODUCTOS DE LA BD */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/eliminar_todop")
    public String elimAllp() {

        servicep.truncateMyTableP();
        return "/listar_p";
    }

    /** FORMULARIO PARA AGREGAR PRODUCTO */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/new_p")
    public String agregarp(Model model) {
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        return "agregar_p";

    }

    /** SALVAR PRODUCTO */
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/save_p")
    public String savep(@Validated Producto pr, Model model) {
        var x = servicep.total();
        try {
            servicep.savep(pr);
        } catch (Exception e) {
            model.addAttribute("doble",
                    "El producto ( " + pr.getNombre() + " ) ya se encuentra registrado en la base de datos");
                    
            return "agregar_p";
            
        }
        if(x < servicep.total()){
        model.addAttribute("suc", "Producto  " + pr.getNombre() + " agregado con éxito");
        return "listar_p";
        }
        model.addAttribute("suc", "Producto  " + pr.getNombre()  + " editado con éxito");
        return "listar_p";
    }

    /** ELIMINAR PRODUCTO */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/eliminar_p/{id}")
    public String deletep(Model model, @PathVariable int id) {
        servicep.deletep(id);
        return "redirect:/listar_p";

    }

    /** EDITAR PRODUCTO */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/editar_p/{id}")
    public String editarp(@PathVariable int id, Model model) {

        Optional<Producto> producto = servicep.listarIdp(id);

        model.addAttribute("producto", producto);
        return "agregar_p";

    }

}

   /*  @GetMapping("/exportarPDF")
    public void exportarPdfu(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("/application/pdf");
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = formatoFecha.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment;filename=Usuarios_" + fechaActual + ".pdf";

        response.setHeader(cabecera, valor);

        List<Usuario> usuarios = service.listAllu();

        UsuarioExporterPDF exporter = new UsuarioExporterPDF(usuarios);

        exporter.exportar(response);

    }

    @GetMapping("/Cerrar")
    public String transparent() {

        return "transparent";
    }

} */