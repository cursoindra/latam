package curso.java.concierto.aspectos;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class AvisadorDeAudiencia {

	@Pointcut("execution(@curso.java.concierto.anotaciones.Vigilado * *.*(..))")
	public void sujetador() {

	}

	@Before("sujetador()")
	public void apagarMoviles() {
		System.out.println("SEÑORES APAGUEN LOS MOVILES QUE VA A EMPEZAR EL CONCIERTO");
	}
	@AfterReturning("sujetador()")
	public void encenderMoviles() {
		System.out.println("SEÑORES YA PUEDEN ENCENDER LOS MOVILES QUE EL COPNCIERTO HA TERMINADO");
	}
	
	@AfterThrowing("sujetador()")
	public void escribirTrazas()
	{
		System.out.println("clase hombre oorquesta; metodo tocar;excepcion de instrumentoi roto sdgsdfhsfgh");
	}

}
