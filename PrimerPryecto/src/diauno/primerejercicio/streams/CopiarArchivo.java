package diauno.primerejercicio.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopiarArchivo
{

	public static void main(String[] args)
	{
		try(FileInputStream fileInputStream= new FileInputStream("camion.jpeg");
				FileOutputStream fileOutputStream= new FileOutputStream("copia de camion1.jpg"))
		{
			byte[] b= new byte[fileInputStream.available()];
		
			fileInputStream.read(b);
			
			fileOutputStream.write(b);
			
			fileOutputStream.flush();
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
