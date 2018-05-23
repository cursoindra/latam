package curso.java.concierto.instrumentos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//@Component("miTambor")
public class Tambor extends Instrumento
{
	//@Value("pom, pom, pom en clasedsfsdfds")
	public void setSonido(String sonido)
	{
		// TODO Auto-generated method stub
		super.setSonido(sonido);
	}

}
