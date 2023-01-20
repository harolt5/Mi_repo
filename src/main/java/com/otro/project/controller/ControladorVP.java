package com.otro.project.controller;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lowagie.text.DocumentException;
import com.otro.project.interfaceService.IventasProductoService;
import com.otro.project.modelo.VentasProducto;
import com.otro.project.util.Reportes.VPExporterEXEL;
import com.otro.project.util.Reportes.VPExporterPDF;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class ControladorVP {

    @Autowired
    private IventasProductoService servicevp;

    /** LISTAR VENTAS-PRODUCTOS **/
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/listar_vp")
    public String listarvpro(Model model, @Param("vppalabraClave") String vppalabraClave) {

        List<VentasProducto> vproductos = servicevp.listAllvp(vppalabraClave);
        if (vproductos.isEmpty() && vppalabraClave == null) {

            model.addAttribute("vacio", "No hay ventas en la base de datos");
        }
        if (vppalabraClave != null && !vproductos.isEmpty()) {
            model.addAttribute("resultados", "Resultados de la búsqueda");
        }
        if (vppalabraClave != null && vproductos.isEmpty()) {
            model.addAttribute("busquedavacia", "La búsqueda no arrojó resultados");
        }
        model.addAttribute("total", servicevp.totalvp());
        model.addAttribute("vproductos", vproductos);
        model.addAttribute("vppalabraClave", vppalabraClave);
        return "listar_vp";
    }

    /* ELIMINAR TODOS LOS PRODUCTOS DE LA BD */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/eliminar_todovp")
    public String elimAllp() {

        servicevp.truncateMyTablevp();
        return "/listar_vp";
    }

    /** FORMULARIO PARA AGREGAR PRODUCTO */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/new_vp")
    public String agregarp(Model model) {
        VentasProducto vproducto = new VentasProducto();
        model.addAttribute("vproducto",vproducto);
        return "agregar_vp";

    }

    /** SALVAR VENTA */
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/save_vp")
    public String savevp(@Validated @ModelAttribute("vproducto") VentasProducto vproducto, Model model,BindingResult result) {
        var x = servicevp.totalvp();

        try {
            servicevp.savevp(vproducto);
        } catch (Exception e) {
            model.addAttribute("doble",
                    "La fecha ( " + vproducto.getFechaDeVenta() + "y la hora " + vproducto.getHoraDeVenta() + " )  ya se encuentran registrados en la base de datos");
                    
            return "agregar_vp";
            
        }
        if(x < servicevp.totalvp()){
        model.addAttribute("suc", "Venta con id " + vproducto.getId() + " agregada con éxito");
        return "listar_vp";
        }
        else
        model.addAttribute("suc", "Venta con id " + vproducto.getId() + " editada con éxito");
        return "listar_vp";
    }


    /** ELIMINAR PRODUCTO */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/eliminar_vp/{id}")
    public String deletep(Model model, @PathVariable int id) {
        servicevp.deletevp(id);
        return "redirect:/listar_p";

    }

    /** EDITAR PRODUCTO */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/editar_vp/{id}")
    public String editarp(@PathVariable int id, Model model) {

        Optional<VentasProducto> vproducto = servicevp.listarIdvp(id);

        model.addAttribute("vproducto", vproducto);
        return "agregar_vp";

    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/exportarPDF")
    public void exportarPdfvp(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("/application/pdf");
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = formatoFecha.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment;filename=Ventas_" + fechaActual + ".pdf";

        response.setHeader(cabecera, valor);

        List<VentasProducto> ventasProductos = servicevp.listAllvp();

        VPExporterPDF exporter = new VPExporterPDF(ventasProductos);

        exporter.exportar(response);

    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/exportarEXEL")
    public void exportarExel(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("/application/octet-stream");
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = formatoFecha.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment;filename=Ventas_" + fechaActual + ".xlsx";

        response.setHeader(cabecera, valor);

        List<VentasProducto> ventasProductos = servicevp.listAllvp();

        VPExporterEXEL exporter = new VPExporterEXEL(ventasProductos);

        exporter.exportarExel(response);

    }

}