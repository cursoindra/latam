package diauno.primerejercicio.streams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class EscribirFicheros
{

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			FileOutputStream fileOutputStream= new FileOutputStream("fichero.txt",true);
			PrintWriter printWriter= new PrintWriter(fileOutputStream);
			printWriter.println("hola como estas");
			printWriter.flush();
			fileOutputStream.close();
			
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}