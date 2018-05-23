package diauno.primerejercicio.streams;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import diauno.primerejercicio.Agenda;

public class EscribirObjeto
{

	public static void main(String[] args)
	{
		Agenda agenda= new Agenda();
		agenda.setNombre("federico");
		agenda.setDireccion("mi casa");
		agenda.setTelefono("43534534");
		
		try(FileOutputStream fileOutputStream= new FileOutputStream("federico.agenda");
				ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);)
		{
			
			objectOutputStream.writeObject(agenda);
			objectOutputStream.flush();
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
