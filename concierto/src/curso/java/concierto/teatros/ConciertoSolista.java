package curso.java.concierto.teatros;

import curso.java.concierto.excepciones.InstrumentoRotoException;
import curso.java.concierto.instrumentos.Instrumento;
import curso.java.concierto.musicos.Musico;
import curso.java.concierto.musicos.Solista;

public class ConciertoSolista
{

	public static void main(String[] args) throws InstrumentoRotoException
	{
		Instrumento instrumento=new Instrumento();
		instrumento.setSonido("nadaxzczxczxcxzcz");
		Solista musico= new Solista();
		musico.tomaInstrumento(instrumento);
		try
		{
			musico.tocar();
		} catch (InstrumentoRotoException e)
		{	
			e.avisarAlPublico();
			//throw e;
		}
		finally
		{
			System.out.println("YA PUEDEN ENCENDER LOS MOVILES");
		}

	}

}
