package diauno.primerejercicio;

public class SegundaClase
{

	public static void main(String[] args)
	{

		int[] numeros = new int[5];
		numeros[0] = 5;
		numeros[1] = 3;
		numeros[2] = 6;
		numeros[3] = 8;
		numeros[4] = 11;

		for (int i = 0; i < numeros.length; i++)
		{
			System.out.println(numeros[i]);
		}

		int[] numeros1 =
		{ 6, 8, 9, 2, 3, 5, 77, 88, 32 };

		for (int i = 0; i < numeros1.length; i++)
		{
			System.out.println(numeros1[i]);
		}

		int[][] n = new int[3][4];
		n[0][0] = 4;
		n[0][1] = 41;
		n[0][2] = 42;
		n[0][3] = 43;
		n[1][0] = 44;
		n[1][1] = 45;
		n[1][2] = 46;
		n[1][3] = 47;
		n[2][0] = 48;
		n[2][1] = 49;
		n[2][2] = 51;
		n[2][3] = 52;
		
		for (int i = 0; i < n.length; i++)
		{
			for(int j=0;j<n[0].length;j++)
			{
				System.out.println(n[i][j]);
			}
			
		}
		
		int[] numeros2={6,8,3,4,66,88,22,1,3,4,39876,45678,987,43,567,876};
		ordenar(numeros2);
		for (int i = 0; i < numeros2.length; i++)
		{
			System.out.println(numeros2[i]);
		}
		
		
		
		

	}
	
	public static void ordenar(int[] numeros)
	{
		boolean ordenado=false;
	
		while(!ordenado)
		{
			ordenado=true;
			for (int i = 0; i < numeros.length-1; i++)
			{
				if(numeros[i]>numeros[i+1])
				{
					int temporal= numeros[i];
					numeros[i]= numeros[i+1];
					numeros[i+1]= temporal;
					ordenado=false;
				}
			}
			
		}
			
	}
	

}














