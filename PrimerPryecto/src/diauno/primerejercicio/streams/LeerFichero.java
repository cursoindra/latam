package diauno.primerejercicio.streams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerFichero
{

	public static void main(String[] args)
	{
		
		try
		{
			FileInputStream fileInputStream= new FileInputStream("fichero.txt");
			InputStreamReader inputStreamReader= new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
			while(bufferedReader.ready())
			{
				System.out.println(bufferedReader.readLine());
			}
			fileInputStream.close();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
