package diauno.primerejercicio;

public class Sobrecarga
{

	public static void main(String[] args)
	{
		System.out.println(suma(8,9));
		System.out.println(suma(8,9,67));
		System.out.println(suma(8,9.5));

	}
	
	public static int suma(int a, int b)
	{
		return a+b;
	}
	public static int suma(int a, int b, int c)
	{
		return a+b+c;
	}
	public static double suma(int a, double b)
	{
		return a+b;
	}

}
