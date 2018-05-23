package curso.java.concierto.teatros;

import curso.java.concierto.excepciones.InstrumentoRotoException;
import curso.java.concierto.instrumentos.Instrumento;
import curso.java.concierto.musicos.Musico;
import curso.java.concierto.musicos.Solista;

public class ConciertoSolista
{

	public static void main(String[] args) throws InstrumentoRotoException
	{
		Instrumento tambor=new Instrumento();
		tambor.setSonido("pom, pom, pom");
		Solista solista= new Solista(tambor);
		//solista.setInstrumento(tambor);
		try
		{
			solista.tocar();
		} catch (InstrumentoRotoException e)
		{	
			e.avisarAlPublico();
			
		}
		

	}

}
