package planilha.excel.apache.teste_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PegaPlanilhaExcel {

	public static void main(String[] args) throws IOException {		
		
		FileInputStream inputPlan = null;
		
		try {
			
			File file = new File("C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\targaryan_1.xlsx");
			inputPlan = new FileInputStream(file);
			
			//Ler todas as planilhas = todas as abas
			XSSFWorkbook workbook = new XSSFWorkbook(inputPlan);
			
			//pegar planilha 1
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			/* o iterator pega a planilha e distribui em linhas */
			Iterator<Row> rowIterator = sheet.iterator();
			
			/* o método hasNext() pega todos os elementos que os próximos da fila */
			while( rowIterator.hasNext() ) {
				
				//pega cada linha da planilha
				Row row = rowIterator.next();
				//pega todas as celulas da planilha
				Iterator<Cell> cellIterator = row.cellIterator();
				
				// pegar todas as celulas da linha atual
				while( cellIterator.hasNext() ) {
					//Pega todas as celulas
					Cell cell = cellIterator.next();
					
					/* Agora precisamos pegar os tipos dos dados contidos na celula com switch case*/
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						System.out.println(" Tipo numerico > "+cell.getNumericCellValue());
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.println(" Tipo String > "+cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_BLANK:
						System.out.println(" Tipo dado vazio > "+cell.getBooleanCellValue());
						break;
					case Cell.CELL_TYPE_FORMULA:
						System.out.println(" Tipo fórmula > "+cell.getCellFormula());
						break;

					default:
						break;
					}
				}
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}finally {
			
		}

	}

}
