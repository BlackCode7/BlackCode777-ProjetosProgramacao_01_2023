package planilha.excel.apache.horasMinutosSegundos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatasEmJava {

	public static void main(String[] args) throws ParseException{

		/* Comparando o vencimento entre datas */
		// Estabelecendo um formato de data dd/MM/yyyy
		// before() -> se a data 1 é menor que a data 2 atual
		// after()  -> se a data 1 é maior que a data 2
		SimpleDateFormat simpledataformat = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dataVencidoBoleto = simpledataformat.parse("21/04/2021");
		
		Date dataAtualHoje = simpledataformat.parse("21/04/2022");
		
		if ( dataVencidoBoleto.before(dataAtualHoje) ) {
			
			System.out.println(" Boleto não Vencido ! ");
			
		} else {
			
			System.out.println( " Boleto Vencido ! " );
			
		}
		
		

	}

}
