package planilha.excel.apache.teste_3;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConhalDataApachePOI {
	
	public Workbook compareWorkbook(String file1, String file2) {
		
		String file = file1;
		String fileOther = file2;
		
		if ( file != null && fileOther != null ) {
			//FileInputStream fileInput = new FileInputStream(file );
			//XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
			//Sheet summarySheet = workbook.getWorksheets().add("Summary_sheet");
			String[] nameOfSource = { "Products", "Sales", "Customers" };
			int totalCol = 0;
			
			
		}
		
		
		return null;
	}

	public static void main(String[] args) {
		

	}

}
