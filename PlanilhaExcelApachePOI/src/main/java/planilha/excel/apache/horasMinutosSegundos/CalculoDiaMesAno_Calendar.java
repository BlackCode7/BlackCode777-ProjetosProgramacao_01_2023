package planilha.excel.apache.horasMinutosSegundos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculoDiaMesAno_Calendar {

	public static void main(String[] args) throws ParseException {
		
		Calendar calendaDataAtual = Calendar.getInstance();//Pega data atual
		Calendar calendaDataMes = Calendar.getInstance();//Pega data atual
		Calendar calendaDataAno = Calendar.getInstance();//Pega data atual

		/* data vinda do banco de dados */
		calendaDataAtual.setTime( new SimpleDateFormat("dd-MM-yyyy").parse("10-03-2021") );
		
		//calendaDataAtual.add(calendaDataAtual.DAY_OF_MONTH, 5);
		calendaDataAtual.add(calendaDataAtual.DAY_OF_MONTH, -5); // trabalhando com dias do mes
		calendaDataMes.add(calendaDataMes.MONTH, -5); // trabalhando com meses
		calendaDataAno.add(calendaDataAno.YEAR, -5); // trabalhando com anos
		
		System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(calendaDataAno.getTime()) + " > trabalhado com anos");
		System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(calendaDataMes.getTime()) + " > trabalhado com meses do ano");
		System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(calendaDataAtual.getTime()) + " > trabalhado com dias do mes");
		
	}

}
