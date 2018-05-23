package curso.java.concierto.teatros;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import curso.java.concierto.excepciones.InstrumentoRotoException;
import curso.java.concierto.musicos.MusicoInterface;
import curso.java.concierto.musicos.Solista;

public class ConcietoSolistaInyectado
{

	public static void main(String[] args)
	{
		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring.xml");
		MusicoInterface solista=(MusicoInterface) ctx.getBean("solista");
		try
		{
			solista.tocar();
		} catch (InstrumentoRotoException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
