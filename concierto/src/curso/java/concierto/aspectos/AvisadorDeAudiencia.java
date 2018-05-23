package curso.java.concierto.aspectos;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
//@Aspect
public class AvisadorDeAudiencia
{

	@Pointcut("execution(* *.tocar(..))")
	public void sujetador()
	{
	}
	
	@Before("sujetador()")
	public void apacgarMoviles()
	{
		System.out.println("SEÑORES APAGUEN LOS moviles que va a empezar el concierto");
	}
	
	@After("sujetador()")
	public void encenderMoviles() {
		System.out.println("SEÑORES YA PUEDEN ENCENDER LOS MOVILES QUE EL CONCIERTO HA TERMINADO");
	}

}
