package planilha.excel.apache.teste_3;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;

public class JuntandoVariasPlpanilhasEmUmaSO {
	
	public static final String fileName = "C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\targaryan_1.xlsx";
		
	public static void main(String[] args) throws IOException {
		
		Workbook wb = new HSSFWorkbook();  // or new XSSFWorkbook();
		Sheet sheet_1 = wb.createSheet("usuario_1");
		Sheet sheet_2 = wb.createSheet("usuario_2");
			
		
		//Criando nome da planillha
		String safeName = WorkbookUtil.createSafeSheetName("['usuario_3'*?]");
		
		Sheet sheet_3 = wb.createSheet(safeName);
		
		FileOutputStream fileOutput = new FileOutputStream("UnionWorkBookExcel.xlsx");
		wb.write(fileOutput);
		fileOutput.close();
		

	}

}
