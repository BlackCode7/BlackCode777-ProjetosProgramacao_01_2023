package planilha.excel.apache.teste_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

import planilha.excel.apache.model.Usuario;

public class Teste_3 {

	public static void main(String[] args) {
		
		//https://www.redspark.io/lendocriando-planilhas-excel-em-java-com-a-biblioteca-apache-poi/

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet( "Usuarios" );
		
		//Definindo layout
		sheet.setDefaultColumnWidth(5);
		sheet.setDefaultRowHeight((short) 400);
		
		//Carregando dados de usuarios
		List<Usuario> lista = new ArrayList<Usuario>();
		Usuario usuarios = new Usuario();
		/*usuarios.setId(1);
		usuarios.setNomeUsuario("Coca");
		usuarios.setEmail("Coca@coca.com");
		usuarios.setEndereco("Endereco_1");
		usuarios.setSalario(222);
		lista.add(usuarios);*/
					
		//Configurando estilos de células (Cores, alinhamento, formatação, etc..)
		HSSFDataFormat numberFormat = workbook.createDataFormat();
		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
		headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		
		CellStyle numberStyle = workbook.createCellStyle();
		numberStyle.setDataFormat(numberFormat.getFormat("#,##0.00"));
		numberStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		
		int rownum = 0;
		int cellnum = 0;
		Cell cell;
		Row row;
		
		row = sheet.createRow(rownum++);
		cell = row.createCell(cellnum ++ );
		cell.setCellStyle(headerStyle);
		cell.setCellValue("id");

		cell = row.createCell(cellnum ++ );
		cell.setCellStyle(headerStyle);
		cell.setCellValue("nome usuário");

		cell = row.createCell(cellnum ++ );
		cell.setCellStyle(headerStyle);
		cell.setCellValue("e-mail");

		cell = row.createCell(cellnum ++ );
		cell.setCellStyle(headerStyle);
		cell.setCellValue("endereço");

		cell = row.createCell(cellnum ++ );
		cell.setCellStyle(headerStyle);
		cell.setCellValue("salário");
		
		// Adicionando os dados dos usuários na planilha
		for ( Usuario usuario: lista ) {

			row = sheet.createRow(rownum ++);			
			
			cellnum = 0;
			/*
			cell = row.createCell(cellnum ++);
			cell.setCellStyle(numberStyle);
			cell.setCellValue(usuario.getId()); //campo id
			cell = row.createCell(cellnum ++);
			cell.setCellStyle(numberStyle);
			cell.setCellValue(usuario.getNomeUsuario());//campo nome
			cell = row.createCell(cellnum ++);
			cell.setCellStyle(numberStyle);
			cell.setCellValue(usuario.getEmail());//campo email
			cell = row.createCell(cellnum ++);
			cell.setCellStyle(numberStyle);
			cell.setCellValue(usuario.getEndereco());//campo endereço
			cell = row.createCell(cellnum ++);
			cell.setCellStyle(numberStyle);
			cell.setCellValue(usuario.getSalario());//campo salário 
			*/  
		}
		
		try {
			//Escrevendo o arquivo em disco
			FileOutputStream out = new FileOutputStream( new File( "C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\testeDia05092022.xls" ) );
			workbook.write(out);
			//workbook.save("C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\testeDia05092022.xls");
			out.close();

			System.out.println(" Arquivo gravado com SUCESSO!");
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
