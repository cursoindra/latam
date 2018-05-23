package curso.java.concierto.configuracion;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import curso.java.concierto.instrumentos.Tambor;

/*
 * <context:component-scan base-package="curso.java.concierto.musicos"></context:component-scan>
	<context:component-scan base-package="curso.java.concierto.instrumentos"></context:component-scan>


 */
@Configuration

@ComponentScan(value= {"curso.java.concierto.instrumentos",
		"curso.java.concierto.musicos","curso.java.concierto.aspectos"})

@EnableAspectJAutoProxy
public class Configuracion
{
	
	@Bean(name="tambor11")
	
	public Tambor getTambor()
	{
		Tambor tambor= new Tambor();
		tambor.setSonido("sonido de tambor en clase");
		return tambor;
	}
	

}











