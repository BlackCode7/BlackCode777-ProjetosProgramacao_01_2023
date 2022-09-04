package planilha.excel.apache.teste_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import planilha.excel.apache.model.Usuario;

public class CódigoQueCriaSalvaDadosUmArquivoExcel {

	private static final String fileName = "C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\targaryan_1.xls";
	
	public static void main(String[] args)  throws IOException {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheetUsuarios = workbook.createSheet("Usuarios");
		
		List<Usuario> listusuarios = new ArrayList<Usuario>();
		
		listusuarios.add( new Usuario(10, "Anderson", "Anderson@Anderson.com", "End_Anderson", 11122) );
		listusuarios.add( new Usuario(20, "Andre", "Andre@Andre.com", "End_Andre", 11123) );
		listusuarios.add( new Usuario(30, "Carlos", "Carlos@Carlos.com", "End_Carlos", 11124) );
		listusuarios.add( new Usuario(40, "Simone", "Simone@Simone.com", "End_Simone", 11125) );
				
		int rowNum = 0;//Criar o iterator para controlar as linhas do excel
		
		for( Usuario usuario: listusuarios ) {
			Row row = sheetUsuarios.createRow(rowNum ++ );
			
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
		
		try {
			//final String fileNameOutPut = "C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI";
			FileOutputStream arquivoOut = new FileOutputStream( new File( CódigoQueCriaSalvaDadosUmArquivoExcel.fileName ) );
			//fileNameOutPut.
			workbook.write(arquivoOut);
			arquivoOut.close();
			
			File file = new File();
			
			System.out.println("Arquivo criado com sucesso!");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo não encontrado!");
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na edição do arquivo!");
		}
		
		

	}

}
