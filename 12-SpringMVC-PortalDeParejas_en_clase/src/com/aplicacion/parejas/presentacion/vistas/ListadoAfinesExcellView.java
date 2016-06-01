package com.aplicacion.parejas.presentacion.vistas;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.aplicacion.parejas.modelo.entidades.Persona;

public class ListadoAfinesExcellView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook book, HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		List<Persona> afines = (List<Persona>) model.get("afines");
         
        HSSFSheet sheet = book.createSheet("Listado de personas Afines");
        sheet.setDefaultColumnWidth(30);
         
        HSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("Nombre");
        header.createCell(1).setCellValue("Apellido");
        header.createCell(2).setCellValue("Altura");
        header.createCell(3).setCellValue("Edad");
        header.createCell(4).setCellValue("Sexo");
         
        int rowCount = 1;
         
        for (Persona p : afines) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(p.getNombre());
            aRow.createCell(1).setCellValue(p.getApellido());
            aRow.createCell(2).setCellValue(p.getEdad());
            aRow.createCell(3).setCellValue(p.getAltura());
            aRow.createCell(4).setCellValue(p.getSexo());
        }
        
        res.setContentType("application/vnd.ms-excel");
        res.setHeader("Content-disposition", "attachment; filename=books.xls");

	}

}
