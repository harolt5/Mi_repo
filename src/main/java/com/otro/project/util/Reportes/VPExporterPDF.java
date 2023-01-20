package com.otro.project.util.Reportes;

import java.io.IOException;
import java.util.List;

import java.awt.Color;

import com.otro.project.modelo.VentasProducto;

import jakarta.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VPExporterPDF {

    private List<VentasProducto> listaVP;

    public VPExporterPDF(List<VentasProducto> listaVP) {
        this.listaVP = listaVP;
    }

    private void escribirCabeceraDeLaTabla(PdfPTable tabla) {

        PdfPCell celda = new PdfPCell();
        celda.setBackgroundColor(Color.BLUE);
        celda.setPadding(5);

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(Color.WHITE);
        celda.setPhrase(new Phrase("id", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Comprador", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Fecha de venta", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Hora de venta", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Productos vendidos", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Núcleo", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Importe total", fuente));
        tabla.addCell(celda);


    }

    private void escribirDatosDeLaTabla(PdfPTable tabla) {
        for (VentasProducto ventasProducto : listaVP) {
            tabla.addCell(String.valueOf(ventasProducto.getId()));
            tabla.addCell(ventasProducto.getComprador());
            tabla.addCell(ventasProducto.getFechaDeVenta());
            tabla.addCell(ventasProducto.getHoraDeVenta());
            tabla.addCell(ventasProducto.getProductosVendidos());
            tabla.addCell(String.valueOf(ventasProducto.getNucleo()));
            tabla.addCell(String.valueOf(ventasProducto.getImporteTotal()));
        }

    }

    public void exportar(HttpServletResponse response) throws DocumentException, IOException {

        Document documento = new Document(PageSize.A4);

        PdfWriter.getInstance(documento, response.getOutputStream());

        documento.open();

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(Color.BLUE);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Lista de ventas", fuente);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);

        PdfPTable tabla = new PdfPTable(7);
        tabla.setWidthPercentage(100f);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[] { 1f, 4f, 2f, 2f, 6f,2f ,1.5f });
        tabla.setWidthPercentage(110);

        escribirCabeceraDeLaTabla(tabla);
        escribirDatosDeLaTabla(tabla);

        documento.add(tabla);
        documento.close();

    }

}
