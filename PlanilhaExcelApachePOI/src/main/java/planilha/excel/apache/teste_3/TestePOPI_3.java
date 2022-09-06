package planilha.excel.apache.teste_3;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestePOPI_3 {
	
	/* https://www.baeldung.com/apache-poi-insert-excel-row */

	public static void main(String[] args) throws IOException {

		int startRow = 2;
	    int rowNumber = 1;
	    final String fileName = "C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\targaryan_1.xlsx";
	    
	    Workbook workbook = new XSSFWorkbook(fileName);
	    Sheet sheet = workbook.getSheetAt(0);
	    
	    int lastRow = sheet.getLastRowNum();
	    
	    Iterator rows = sheet.rowIterator();
	    
	    	if( lastRow < startRow ) {
	    		
		    	sheet.createRow(startRow);

		    }
	    
	    
	    sheet.shiftRows(startRow, lastRow, rowNumber, true, true);
	    sheet.createRow(startRow);

	    FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\new_FileOutputStream_file_excel.xlsx");
	    workbook.write(outputStream);
	    
	    //File file = new File("C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\new_File_file_excel.xlsx");
	    
	    //final int expectedRowResult = 5;
	    //Assertions.assertEquals( expectedRowResult, workbook.getSheetAt(0), getLastRowNum());
	
	    outputStream.close();
	    //file.delete();
	    ((FileOutputStream) workbook).close();
	
	}



}
















