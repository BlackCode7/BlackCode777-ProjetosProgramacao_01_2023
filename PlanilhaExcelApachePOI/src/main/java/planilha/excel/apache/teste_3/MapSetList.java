package planilha.excel.apache.teste_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapSetList {

	public static void main(String[] args) {

		System.out.println("********************* List *********************");
		/* para List usa ArrayList() */
		List<Integer> lista;
		lista = new  ArrayList<>();
		lista.add(1);
		lista.add(null);
		lista.add(null);
		lista.add(null);
		lista.add(12);
		lista.add(9);
		lista.add(55);
		lista.add(10000);		
		printValuesList(lista);
		
		System.out.println("********************* Set *********************");
		
		/* para Set usa HashSet() */		
		Set<Integer> setLista;
		setLista = new HashSet<Integer>();
		setLista.add(1);
		setLista.add(23);
		setLista.add(null);
		setLista.add(322);
		setLista.add(1000);
		setLista.add(322);
		printSet(setLista);
		
		System.out.println("********************* Map *********************");
		
		Map<String, Integer> listaMap = new HashMap<>();
		listaMap.put( "Carro", 2000 );
		listaMap.put( "Cachorro", 2000 );
		listaMap.put( "Casa", 200020 );
		listaMap.put( "Moto", 20000 );
		listaMap.put( "PlayStation", 5000 );
		listaMap.put( "Ryzen7", 2500 );
		listaMap.put( "TecladoRedDragon", 600 );
		
		printMap(listaMap);
	}

	private static void printMap( Map<String, Integer> item ) {
		item.forEach((chave, valor) -> {
			System.out.println("chave: " + chave + " , valor: " + valor);
		});		
	}

	private static void printSet( Set<Integer> item ) {		
		Iterator<Integer> iterator = item.iterator();
		while( iterator.hasNext() ) {
			System.out.println(iterator.next());
		}		
	}

	private static void printValuesList( List<Integer> item ) {
		for( int i = 0; i < item.size(); i++) {
			System.out.println(item.get(i));//item.get(i)
		}		
	}

}
