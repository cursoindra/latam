package diauno.primerejercicio.calendarios;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Calendario
{

	public static void main(String[] args)
	{
		GregorianCalendar fecha= new GregorianCalendar(5689,5,31567);
		//System.out.println(fecha);
		
		String salida="";
		String diaSemana=fecha.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ITALIAN);
		String diaDelMes=fecha.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ITALIAN);
		salida=diaSemana+", "+fecha.get(Calendar.DAY_OF_MONTH)+" de "+diaDelMes+" de "+fecha.get(Calendar.YEAR);
		System.out.println(salida);

	}

}
