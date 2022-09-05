package planilha.excel.apache.teste_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import planilha.excel.apache.model.Usuario;

public class JuntandoVariasPlpanilhasEmUmaSO {
	
	public static final String fileName = "C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\targaryan_1.xls";
		
	public static void main(String[] args) throws IOException {
		
		ArrayList< Usuario > usuarioLista = new ArrayList<Usuario>();
		
		FileInputStream arquivo = new FileInputStream( new File( JuntandoVariasPlpanilhasEmUmaSO.fileName ) );
		
		HSSFWorkbook workbook = new HSSFWorkbook(arquivo);
		HSSFSheet sheetUsuarios = workbook.getSheetAt(0);
		
		for ( Row planilha: sheetUsuarios ) {
			//System.out.println(planilha);
		}
		
		System.out.println(sheetUsuarios);
		

	}

}
