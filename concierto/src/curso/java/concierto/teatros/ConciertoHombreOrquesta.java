package curso.java.concierto.teatros;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import curso.java.concierto.excepciones.InstrumentoRotoException;
import curso.java.concierto.instrumentos.Instrumento;
import curso.java.concierto.musicos.HombreOrquesta;

public class ConciertoHombreOrquesta
{

	public static void main(String[] args)
	{
		HombreOrquesta hombreOrquesta= new HombreOrquesta();
		Instrumento tambor= new Instrumento("wpom, pom, pom");
		Instrumento trompeta= new Instrumento("jtuuu, tuuu, tuuu");
		Instrumento guitarra= new Instrumento("wpom, pom, pom");
		hombreOrquesta.setInstrumentos(new HashSet<>());
		
		
		hombreOrquesta.getInstrumentos().add(trompeta);
		hombreOrquesta.getInstrumentos().add(guitarra);
		hombreOrquesta.getInstrumentos().add(tambor);
		hombreOrquesta.getInstrumentos().add(tambor);
		hombreOrquesta.getInstrumentos().add(trompeta);
		hombreOrquesta.getInstrumentos().add(guitarra);
		hombreOrquesta.getInstrumentos().add(tambor);
		hombreOrquesta.getInstrumentos().add(trompeta);
		hombreOrquesta.getInstrumentos().add(guitarra);
		hombreOrquesta.getInstrumentos().add(tambor);
		hombreOrquesta.getInstrumentos().add(trompeta);
		hombreOrquesta.getInstrumentos().add(guitarra);
		try
		{
			hombreOrquesta.tocar();
		} catch (InstrumentoRotoException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
