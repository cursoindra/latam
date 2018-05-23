package curso.java.concierto.aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import curso.java.concierto.excepciones.InstrumentoRotoException;
import curso.java.concierto.instrumentos.Instrumento;
import curso.java.concierto.musicos.Musico;
import curso.java.concierto.musicos.MusicoInterface;
import curso.java.concierto.musicos.Solista;

//@Component
@Aspect
public class PropietarioDelTeatro
{
	@Pointcut("execution(@curso.java.concierto.anotaciones.Vigilado * *.*(..))")
	public void sujetador()
	{
		
	}
	
	@Around("sujetador()")
	public Object vigilarTodo(ProceedingJoinPoint joinPoint) throws InstrumentoRotoException
	{
	
		try
		{
			System.out.println("Apaguen los moviles");
			Object salida=joinPoint.proceed();
			System.out.println("Enciendan los moviles");
			return salida;
		} catch (Throwable e)
		{
			//AfterThrowing
			if(e.getClass().isInstance(new InstrumentoRotoException()))
			{
				
				System.out.println("Se ha roto el instrumento, lo voy a arreglar");
				Musico musico=(Musico) joinPoint.getTarget();
				if(musico.getClass().isInstance(new Solista()))//(Solista.class.equals(usico.getClass())
				{
					musico.getInstrumento().setSonido("sonido arreglado de "+musico.getInstrumento().getClass().getSimpleName());
					
				}
				else
				{
					for (Instrumento		 instrumento : musico.getInstrumentos())
					{
						if(instrumento.getSonido().equals("nada"))
						{
							instrumento.setSonido("sonido arreglado de "+instrumento.getClass().getSimpleName());
						}
						
					}
					
				}
				System.out.println("señores todo arreglado continuamos el concierto");
				
				musico.tocar();	
			}
			return null;
		}
		
		
	}

}
