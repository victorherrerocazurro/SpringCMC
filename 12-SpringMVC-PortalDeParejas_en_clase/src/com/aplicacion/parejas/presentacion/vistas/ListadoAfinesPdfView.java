package com.aplicacion.parejas.presentacion.vistas;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.aplicacion.parejas.modelo.entidades.Persona;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ListadoAfinesPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter out, HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		List<Persona> afines = (List<Persona>) model.get("afines");
        
        doc.add(new Paragraph("Listado de personas afines"));
         
        Table table = new Table(2);
		table.addCell("Nombre");
		table.addCell("Apellido");
		table.addCell("Edad");
		table.addCell("Altura");
		table.addCell("Sexo");
 
        for (Persona p : afines) {
            table.addCell(p.getNombre());
            table.addCell(p.getApellido());
            table.addCell(String.valueOf(p.getEdad()));
            table.addCell(String.valueOf(p.getAltura()));
            table.addCell(p.getSexo());
        }
         
        doc.add(table);
		
		
	}

}
