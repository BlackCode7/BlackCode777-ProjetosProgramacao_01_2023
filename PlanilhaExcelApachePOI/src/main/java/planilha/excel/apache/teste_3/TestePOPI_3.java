package planilha.excel.apache.teste_3;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestePOPI_3 {
	
	/* https://www.baeldung.com/apache-poi-insert-excel-row */
	/* https://stackoverflow.com/questions/27401694/how-compare-2-different-excel-xls-sheets-using-apache-poi-and-java */
	

	public static void getRow( String file ) {
		
		try {
			FileInputStream fileInput = new FileInputStream(file);
			
			Workbook workbook = new XSSFWorkbook(fileInput);
						
			Sheet sheet1 = workbook.getSheetAt(0);
			Sheet sheet2 = workbook.getSheetAt(1);
			
			Iterator<Row> rowIterator1 = sheet1.iterator();			
			Iterator<Row> rowIterator2 = sheet2.iterator();			
			
			while( rowIterator1.hasNext() || rowIterator2.hasNext() ) {
				Row currentRow1 = rowIterator1.next();
				Row currentRow2 = rowIterator2.next();
				
				Iterator<Cell> cellIterator1 = currentRow1.iterator();
				Iterator<Cell> cellIterator2 = currentRow2.iterator();				
				
				//System.out.println(" celula 1 >> "+cellIterator1);
				
				while( cellIterator1.hasNext() || cellIterator2.hasNext()) {
					Cell currentCell1 = cellIterator1.next();					
					Cell currentCell2 = cellIterator2.next();
					
					//System.out.println(" celula 2 >> "+cellIterator1);
					
					/* logica para comparar os valores */
				}
			}
			
			/* SALVAR ARQUIVO AQUI */
			
		} catch (Exception erro) {
			erro.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		
		final String fileName1 = "C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\targaryan_1.xlsx";

		getRow(fileName1);


	    /*********************************************
		int startRow = 2;
	    int rowNumber = 1;	
	    final String fileName1 = "C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\targaryan_1.xlsx";
	    final String fileName2 = "C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\targaryan_2.xlsx";	    
	    Workbook workbook1 = new XSSFWorkbook(fileName1);
	    Workbook workbook2 = new XSSFWorkbook(fileName2);	    
	    Sheet sheet1 = workbook1.getSheetAt(0);	 
	    Sheet sheet2 = workbook2.getSheetAt(0);	    
	    int lastRow1 = sheet1.getLastRowNum();	
	    int lastRow2 = sheet2.getLastRowNum();		    
	    	if( lastRow1 < startRow ) {	    		
		    	sheet1.createRow(startRow);
		    	if( lastRow2 < startRow ) {	    		
			    	sheet2.createRow(rowNumber);	   	
			    }
		    	System.out.println("AQUI sheet2 >>> "+sheet2);
		    }
	    	System.out.println("AQUI sheet1 >>> "+sheet1);
	    sheet1.shiftRows(startRow, lastRow1, rowNumber, true, true);
	    sheet1.createRow(startRow);
	    FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\new_FileOutputStream_file_excel.xlsx");
	    workbook1.write(outputStream);
	    outputStream.close();
	    ((FileOutputStream) workbook1).close();		    
	    **********************************************/
	}



}
















