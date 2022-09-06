package planilha.excel.apache.teste_3;

import java.io.IOException;
import java.io.InputStream;
  

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;

public class AdvancedWorkbook  {
		

	public void addSheet(HSSFSheet sheet1) {
		System.out.println("Criar logica para adicionar sheets 1");
	}

	public void setSheetName(int i, String sheetName) {
		System.out.println("Criar logica para adicionar sheets 2");
	}

	
	
}
