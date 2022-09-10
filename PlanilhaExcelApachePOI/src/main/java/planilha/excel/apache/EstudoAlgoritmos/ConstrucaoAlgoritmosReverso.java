package planilha.excel.apache.EstudoAlgoritmos;

public class ConstrucaoAlgoritmosReverso {

	public static void main(String[] args) {

		String[] string = { "carro", "ferro", "martelo" };
		for( String ss: string  ) {
			System.out.println(ss);			
			int[] table = {10, 20, 30, 40};
			if( table[0] > 10 || table[1] == 20 ) {
				for( int tt: table ) {
					System.out.println(tt);					
					/*double[] dd = {12.3, 43.33, 45.2};
					for(double sss: dd) {
						System.out.println(sss);
					}*/				
				}
			}			
		}		
	}
}
