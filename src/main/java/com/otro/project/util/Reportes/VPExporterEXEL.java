package com.otro.project.util.Reportes;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.otro.project.modelo.VentasProducto;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class VPExporterEXEL {

    private XSSFWorkbook libro;
    private XSSFSheet hoja;

    private List<VentasProducto> listaVentasProducto;

    public VPExporterEXEL(List<VentasProducto> listaVentasProducto) {
        this.listaVentasProducto = listaVentasProducto;
        libro = new XSSFWorkbook();
        hoja = libro.createSheet("VentasProducto");
    }

    private void escribirCabeceraDeTabla() {

        Row fila = hoja.createRow(0);

        CellStyle estilo = libro.createCellStyle();

        XSSFFont fuente = libro.createFont();

        fuente.setBold(true);
        fuente.setFontHeight(16);
        estilo.setFont(fuente);

        Cell celda = fila.createCell(0);
        celda.setCellValue("Id");
        celda.setCellStyle(estilo);

        celda = fila.createCell(1);
        celda.setCellValue("Comprador");
        celda.setCellStyle(estilo);

        celda = fila.createCell(2);
        celda.setCellValue("Fecha de venta");
        celda.setCellStyle(estilo);

        celda = fila.createCell(3);
        celda.setCellValue("Hora de venta");
        celda.setCellStyle(estilo);

        celda = fila.createCell(4);
        celda.setCellValue("Productos vendidos");
        celda.setCellStyle(estilo);

        celda = fila.createCell(5);
        celda.setCellValue("Núcleo");
        celda.setCellStyle(estilo);

        celda = fila.createCell(6);
        celda.setCellValue("Importe total");
        celda.setCellStyle(estilo);

    }

    private void escribirDatosDeLaTabla() {

        int numeroDeFilas = 1;

        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setFontHeight(14);
        estilo.setFont(fuente);

        for (VentasProducto ventasProducto : listaVentasProducto) {
            Row fila = hoja.createRow(numeroDeFilas++);

            Cell celda = fila.createCell(0);
            celda.setCellValue(ventasProducto.getId());
            hoja.autoSizeColumn(0);
            celda.setCellStyle(estilo);

            celda = fila.createCell(1);
            celda.setCellValue(ventasProducto.getComprador());
            hoja.autoSizeColumn(1);
            celda.setCellStyle(estilo);

            celda = fila.createCell(2);
            celda.setCellValue(ventasProducto.getFechaDeVenta());
            hoja.autoSizeColumn(2);
            celda.setCellStyle(estilo);

            celda = fila.createCell(3);
            celda.setCellValue(ventasProducto.getHoraDeVenta());
            hoja.autoSizeColumn(3);
            celda.setCellStyle(estilo);

            celda = fila.createCell(4);
            celda.setCellValue(ventasProducto.getProductosVendidos());
            hoja.autoSizeColumn(4);
            celda.setCellStyle(estilo);

            celda = fila.createCell(5);
            celda.setCellValue(ventasProducto.getNucleo());
            hoja.autoSizeColumn(5);
            celda.setCellStyle(estilo);

            celda = fila.createCell(6);
            celda.setCellValue(ventasProducto.getImporteTotal());
            hoja.autoSizeColumn(6);
            celda.setCellStyle(estilo);


        }

    }

    public void exportarExel(HttpServletResponse response) throws IOException {

        escribirCabeceraDeTabla();
        escribirDatosDeLaTabla();

        ServletOutputStream outputStream = response.getOutputStream();

        libro.write(outputStream);

        libro.close();

        outputStream.close();

    }
    
}
