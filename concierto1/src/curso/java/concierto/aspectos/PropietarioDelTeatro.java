package curso.java.concierto.aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import curso.java.concierto.excepciones.InstrumentoRotoException;
import curso.java.concierto.instrumentos.Instrumento;
import curso.java.concierto.musicos.Musico;
import curso.java.concierto.musicos.Solista;

@Aspect
@Component
public class PropietarioDelTeatro {
	
	@Pointcut("execution(@curso.java.concierto.anotaciones.Vigilado * *.*(..))")
	public void sujetador()
	{}
	
	@Around("sujetador()")
	public Object hacerTodo(ProceedingJoinPoint joinPoint) throws Exception{
		Object salida= null;
		Musico musico= (Musico) joinPoint.getTarget();
		
		try {
			//BEFORE
			System.out.println("SEÑORES APAGUEN LOS MOVILES QUE VA A EMPEZAR EL CONCIERTO SOY EL PROPIETARIO");
			salida=joinPoint.proceed();
			//AFTERRETURNING
		} catch (Throwable e) {
			//AFTERTHROWING
			System.out.println("SEÑORES, SE HA ROTO EL INSTRUMENTO, VOY A ARREGLARLO");
			if(musico.getClass().isInstance(new Solista()))
			{
				musico.getInstrumento().setSonido("sonido arreglado del instrumento del solista");
				System.out.println("SEÑORES, YA ESTA ARREGLADO EL INSTRUMENTO, CONTINUAMOS EL CONCIERTO");
				
			}
			else
			{
				for (Instrumento instrumento : musico.getInstrumentos()) {
					if(instrumento.getSonido().equals("nada"))
					{
						instrumento.setSonido("sonido arreglado al instrumento "+instrumento.getClass());
					}
				}
				System.out.println("SEÑORES, YA ESTAN ARREGLADOS LOS INSTRUMENTOS, CONTINUAMOS EL CONCIERTO");
				
			}
			
			musico.tocar();
		}
		//AFTER
		System.out.println("SEÑORES YA PUEDEN ENCENDER LOS MOVILES QUE EL CONCIERTO HA TERMINADO SOY EL PROPIETARIO");

		return salida;
		
		
		
	}

}
