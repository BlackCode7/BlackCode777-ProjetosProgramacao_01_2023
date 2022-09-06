package planilha.excel.apache.teste_3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import planilha.excel.apache.model.Usuario;

public class ApachePOITutorial_Metodo {
	
	public List<Usuario> criar() throws IOException{
		/* Criando uma lista de usuarios */
		List<Usuario> usuarios = new ArrayList<Usuario>();
				
		FileInputStream file = new FileInputStream("C:\\Users\\Usuario\\Documents\\volumetria_eventos_iirgd_v2_1662386537036.xlsx");
		System.out.println(file);
		
		/* recuperando o arquivo excel */
		Workbook workbook = new XSSFWorkbook(file);
		System.out.println(workbook);
		
		/* lendo a aba da planilha */
		Sheet sheet = workbook.getSheetAt(0);
		
		List<Row> rows = (List<Row>) toList(sheet.iterator());
		
		/* lendo as linhas da planilha*/
		Iterator<Row> iterator = sheet.iterator();
		
		int rowNum = 0;
		
		/* percorrendo cada linha */
		for( Usuario usuario: usuarios ) {
			Row row = sheet.createRow(rowNum ++ );
			
			int cellNum = 0;//Percorrendo as colunas da planilha
			
			Cell cellID = row.createCell(cellNum ++ );
			cellID.setCellValue(usuario.getId());
			
			Cell cellNome = row.createCell(cellNum ++ );
			cellNome.setCellValue(usuario.getNomeUsuario());
			
			Cell cellEmail = row.createCell(cellNum ++ );
			cellEmail.setCellValue(usuario.getEmail());
			
			Cell cellEndereco = row.createCell(cellNum ++ );
			cellEndereco.setCellValue(usuario.getEndereco());
			
			Cell cellSalario = row.createCell(cellNum ++ );
			cellSalario.setCellValue(usuario.getSalario());
			
		}		
		
		return usuarios;
	}
	
	public List<?> toList( Iterator<?> iterator ){
		return IteratorUtils.toList(iterator);
	}

	public void imprimir( List<Usuario> usuarios ) {
		usuarios.forEach(System.out::println);
	}
}














