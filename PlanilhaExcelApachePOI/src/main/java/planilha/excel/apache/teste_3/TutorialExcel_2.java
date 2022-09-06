package planilha.excel.apache.teste_3;

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

public class TutorialExcel_2 {

	private static final String fileName = "C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\ok_1.xls";
	
	public static void main(String[] args) throws IOException {
		
		HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheetUsuarios = workbook.createSheet("Usuarios");
        
        int rownum = 0;
        
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios.add( new Usuario( 1, "anana", "email@email.com", "endereco", 22222 ));
        
		for( Usuario user: listaUsuarios  ) {
        	
			Row row = sheetUsuarios.createRow(rownum++);
			int cellnum = 0;
			
			Cell cellid = row.createCell(rownum++);
			cellid.setCellValue(user.getId());
			
			Cell cellname = row.createCell(rownum++);
			cellname.setCellValue(user.getNomeUsuario());
			
			Cell cellemail = row.createCell(rownum++);
			cellemail.setCellValue(user.getEmail());
			
			Cell cellendereco = row.createCell(rownum++);
			cellendereco.setCellValue(user.getEndereco());
			
			Cell cellsalario = row.createCell(rownum++);
			cellsalario.setCellValue(user.getSalario());			
        }

		try {
			FileOutputStream out = new FileOutputStream(new File( TutorialExcel_2.fileName ));
			System.out.println(out);
			workbook.write(out);
			out.close();
			System.out.println("Arquivo criado !!!! ");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo não encontrado");
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na edição do arquivo !!! ");
			
		}
	}

}
