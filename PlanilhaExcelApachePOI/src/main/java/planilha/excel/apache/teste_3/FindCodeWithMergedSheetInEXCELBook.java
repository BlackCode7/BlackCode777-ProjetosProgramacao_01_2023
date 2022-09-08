package planilha.excel.apache.teste_3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class FindCodeWithMergedSheetInEXCELBook {
	
	//https://coderanch.com/t/420958/open-source/Copying-sheet-excel-file-another	
	
	public static void mergeExcelFiles() {
		
		HSSFWorkbook book1 = null;
		HSSFWorkbook book2 = null;
		HSSFSheet sheet1 = null;
		HSSFSheet sheet2 = null;
		
		try {
			
			book1 = new HSSFWorkbook(new FileInputStream("C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\targaryan_1.xls"));
			sheet1 = book1.getSheetAt(0);
			
			book2 = new HSSFWorkbook(new FileInputStream("C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\targaryan_2.xls"));
			sheet2 = book2.getSheetAt(0);
			
			System.out.println(sheet1.equals(sheet2));
			
			try {
				
				AdvancedWorkbook mergedBook = new AdvancedWorkbook();
				
				mergedBook.addSheet(sheet1);
				mergedBook.setSheetName(0, book1.getSheetName(0));
				
				mergedBook.addSheet(sheet2);
			    mergedBook.setSheetName(1, book2.getSheetName(0));
			    
			    FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\fusionFILEsuccess.xls"        ,false);
			    ((Workbook) mergedBook).write(fileOut);
			    fileOut.close();
			    
			    System.out.println("FUSÃO feita com sucesso!!!");
				
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {

		mergeExcelFiles();

	}

}
