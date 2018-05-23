package diauno.primerejercicio.streams;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import diauno.primerejercicio.Agenda;

public class LeerObjeto
{

	public static void main(String[] args)
	{
		try(FileInputStream fileInputStream= new FileInputStream("federico.agenda");
				ObjectInputStream objectInputStream= new ObjectInputStream(fileInputStream))
		{
			Agenda agenda= (Agenda) objectInputStream.readObject();
			System.out.println("nombre:"+agenda.getNombre());
			System.out.println("direccion:"+agenda.getDireccion());
			System.out.println("telefono:"+agenda.getTelefono());
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}

	}

}
