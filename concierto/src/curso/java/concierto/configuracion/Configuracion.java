package curso.java.concierto.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import curso.java.concierto.aspectos.PropietarioDelTeatro;
import curso.java.concierto.instrumentos.Tambor;

/*
 	<context:component-scan base-package="curso.java.concierto.instrumentos" />
	<context:component-scan base-package="curso.java.concierto.musicos" />
	<context:component-scan base-package="curso.java.concierto.aspectos" />

	<aop:aspectj-autoproxy></aop:aspectj-autoproxy>

 */


@ComponentScan(value= {"curso.java.concierto.instrumentos",
		"curso.java.concierto.musicos","curso.java.concierto.aspectos"})
@EnableAspectJAutoProxy
public class Configuracion
{
	@Bean
	public PropietarioDelTeatro getPropietarioDelTeatro()
	{
		return new PropietarioDelTeatro();
	}
	
	@Bean
	public Tambor getTambor()
	{
		Tambor tambor= new Tambor();
		tambor.setSonido("nada");
		return tambor;
	}
	

}











