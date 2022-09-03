package planilha.excel.apache.horasMinutosSegundos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HorasMinutosSegundos {

	public static void main(String[] args)    {
		
		//Calendar calendar = new Calendar().getInstance();
		//calendar.get(Calendar.DATE);		
		
		System.out.println("*****************************************************************");

		Date data = new Date();
		//Calendar calendar = new Calendar();		
		System.out.println(data.getDay()+ " > dia da semana"); 
		System.out.println(data.getDate()+" > dia do mês ");
		System.out.println(data.getTime() + " > milesegundos");// representa milisegundos
		System.out.println(data.getHours()+" > Horas do dia");
		System.out.println(data.getMinutes() + " > minutos");
		System.out.println(data.getSeconds() + " > segundos");
		System.out.println(data.getTime());
		
		System.out.println("******************* SimpleDateFormat - formata data p/String *********************"); 
		
		// Com SimpleDateFormat() eu crio um padrão de formato de datas como exemplo:
		// MM-dd-yyy / dd-MM-yyyy / dd/MM/yyyy / yyyy/MM/dd
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // fromato - 1
		//simpleDateFormat = new SimpleDateFormat("dd/yyyy/MM"); // formato - 2
		//simpleDateFormat = new SimpleDateFormat("dd-yyyy-MM"); // formato - 3
		//simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy"); // formato - 4
		//simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm"); // formato - 4
		//simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm.ss"); // formato - 4
		
		// compara se existe diferença entre datas e se for true apresenta a data em formato especifico 
		// ou outro formato especificado com o SimpleDateFormat()
		if ( simpleDateFormat.equals(data)  ) {
			System.out.println(" Dentro da condição IF !!!");
			System.out.println(simpleDateFormat.format(data));
		} else {
			System.out.println(" Dentro da condição ELSE !!!");
			SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			System.out.println(simpleDateFormat1.format(data));
		}
		
		System.out.println(simpleDateFormat.format(data) + " > SimpleDateFormat() - formato - 4 / dd-MM-yyyy" ); // formato para usuarios
		System.out.println(simpleDateFormat.format(data) + " > SimpleDateFormat() - formato - 3 / dd-yyyy-MM" ); // formato para gravar em banco de dados
		System.out.println(simpleDateFormat.format(data) + " > SimpleDateFormat() - formato - 2 / dd/yyyy/MM" );
		System.out.println(simpleDateFormat.format(data) + " > SimpleDateFormat() - formato - 1 / dd/MM/yyyy");

	}

}
