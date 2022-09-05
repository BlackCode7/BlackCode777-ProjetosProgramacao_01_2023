package planilha.excel.apache.teste_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import planilha.excel.apache.model.Usuario;

public class CodeAbreLeDadosArquivoEXCEL {
	
	private static final String fileName = "C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\targaryan_1.xls";

	public static void main(String[] args) throws IOException {
		ArrayList< Usuario > usuarioLista = new ArrayList<Usuario>();// lista que vai receber os dados dos usuarios 		
		// Caso feliz  XSSFWorkbook e XSSFSheet
		try {
					
			// para abrir o arquivo excel
			FileInputStream arquivo = new FileInputStream( new File( CodeAbreLeDadosArquivoEXCEL.getFilename() ) );	
			HSSFWorkbook workbook = new HSSFWorkbook(arquivo);//pega o arquivo			
			HSSFSheet sheetUsuarios = workbook.getSheetAt(0);//pega o indice 0			
						
			Iterator<Row> rowIterator = sheetUsuarios.iterator(); //chama função Iterator()			
			// Chama o laço de repetição while mas por der o for também
			while ( rowIterator.hasNext() ) {//Iterando nas linhas do excel
				Row row = rowIterator.next();//sempre chama a próxima celula
				Iterator<Cell> cellIterator = row.cellIterator();//iterando sobre as celulas da planilha				
				Usuario usuario = new Usuario();//instanciando o objeto Usuario
				usuarioLista.add(usuario);//Adicionaod na lista de usuario o objeto Usuario instanciado				
				while( cellIterator.hasNext() ) { //iterando nas colunas da planilha
					
					Cell cell = cellIterator.next();//chamando a sempre a próxima celular para formar a coluna					
					switch (cell.getColumnIndex()) {//pegando o index das colunas					
					case 0:
						usuario.setId( cell.getCellType() );//pegando o tipo correto do dado getNumericCellValue()
						break;
					case 1:
						usuario.setNomeUsuario(cell.getStringCellValue());//pegando o tipo String do dado
						break;
					case 2:
						usuario.setEmail(cell.getStringCellValue());//pegando o tipo String do dado
						break;
					case 3:
						usuario.setEndereco(cell.getStringCellValue());//pegando o tipo String do dado
						break;
					case 4:
						usuario.setSalario((int) cell.getNumericCellValue());//pegando o tipo numerico do dado
						break;
					default:
						break;
					}
				}
			}
			
			arquivo.close();//fechando o arquivo excel
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Arquivo excel não encontrado!!!");			
		}

	}

	public static String getFilename() {
		return fileName;
	}

}
