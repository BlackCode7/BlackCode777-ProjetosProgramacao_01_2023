package planilha.excel.apache.teste_3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JuntandoVariasPlpanilhasEmUmaSO {
	
	public static final String fileName = "C:\\Users\\Usuario\\Documents\\DocsExcelApachePOI\\targaryan_1.xlsx";
		
	public static void main(String[] args) throws IOException {
		
		Set<Integer> listaSet;
		
		List<Integer> lista;
		lista = new ArrayList<>();
		lista.add(1);//aicionaelemento na lista
		lista.add(2);//aicionaelemento na lista
		lista.add(3);//aicionaelemento na lista
		lista.add(null);//aicionaelemento na lista
		lista.add(null);//aicionaelemento na lista
		lista.add(20);//aicionaelemento na lista
		lista.add(123);//aicionaelemento na lista // size() pega todos os elementos da lista
		
		print( lista );

	}

	private static void print( List<Integer> item ) {
		
		for( int i = 0; i < item.size(); i++ ) {
			System.out.println(item.get(i));
		}		
	}

}
