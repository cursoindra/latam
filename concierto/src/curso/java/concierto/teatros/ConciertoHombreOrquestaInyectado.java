package curso.java.concierto.teatros;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import curso.java.concierto.configuracion.Configuracion;
import curso.java.concierto.excepciones.InstrumentoRotoException;
import curso.java.concierto.musicos.HombreOrquesta;
import curso.java.concierto.musicos.MusicoInterface;

public class ConciertoHombreOrquestaInyectado
{

	public static void main(String[] args)
	{
		//ApplicationContext ctx= new ClassPathXmlApplicationContext("spring.xml");	
		ApplicationContext ctx= new AnnotationConfigApplicationContext(Configuracion.class)	;
		MusicoInterface hombreOrquesta= (MusicoInterface) ctx.getBean("hombreOrquesta");
		//HombreOrquesta hombreOrquesta1= (HombreOrquesta) ctx.getBean(HombreOrquesta.class);
		try
		{
			hombreOrquesta.tocar();
		} catch (InstrumentoRotoException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
