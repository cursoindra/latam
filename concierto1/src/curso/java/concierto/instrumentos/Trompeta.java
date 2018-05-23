package curso.java.concierto.instrumentos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tocameAMi")
public class Trompeta extends Instrumento
{
	@Value("nada")
	public void setSonido(String sonido)
	{
		// TODO Auto-generated method stub
		super.setSonido(sonido);
	}

}
