package diauno.primerejercicio;

public class PrimeraClase
{

	public static void main(String[] args)
	{

		System.out.println(suma(18, 33));

		int a = 5;
		int b = a++;

		System.out.println("a vale:" + a);
		System.out.println("b vale:" + b);

		int c = 5;
		int d = ++c;

		System.out.println("c vale:" + c);
		System.out.println("d vale:" + d);

		for (int i = 0; i < 100; i++)
		{
			if (i % 2 > 0)
			{
				System.out.println(i);
			}
		}

		int aa = 7;

		switch (aa)
		{
		case 1:
			System.out.println("a vale 1");
			break;
		case 2:
			System.out.println("a vale 2");
			break;
		case 3:
			System.out.println("a vale 3");
			break;
		case 4:
			System.out.println("a vale 4");
			break;
		default:
			System.out.println("a no vale ni 1 ni 2 ni 3 ni 4");

		}

		// TipoDeClase nombreDelObjeto= new constructor

		Agenda agenda = new Agenda();
		agenda.setNombre("Javier");
		agenda.setDireccion("mi casa");
		agenda.setTelefono("9876543");

		// System.out.println(agenda.getNombre()+" - "+agenda.getDireccion()+" -
		// "+agenda.getTelefono());

		agenda.dameDatos();

		byte[] letras =
		{ 64, 65, 78, 43, 56, 99, 101 };

		String texto = new String(letras);
		System.out.println(texto);

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				"dfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfg");
		System.out.println(stringBuilder.toString().length());
		stringBuilder.append("dfghfghdgfhdfghfg");
		System.out.println(stringBuilder.toString().length());
		stringBuilder.append(
				"dfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfg");
		System.out.println(stringBuilder.toString().length());
		stringBuilder.append("dfghfghdgfhdfghfg");
		System.out.println(stringBuilder.toString().length());
		stringBuilder.append(
				"dfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfg");
		System.out.println(stringBuilder.toString().length());
		stringBuilder.append("dfghfghdgfhdfghfg");
		System.out.println(stringBuilder.toString().length());
		stringBuilder.append("dfghfghdgfhdfghfg");
		System.out.println(stringBuilder.toString().length());
		stringBuilder.append(
				"dfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfg");
		System.out.println(stringBuilder.toString().length());
		stringBuilder.append("dfghfghdgfhdfghfg");
		stringBuilder.append(
				"dfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfgdfghfghdgfhdfghfg");

		System.out.println(stringBuilder.toString().length());
		
		
		
		
		int n1=123456;
		short n2=(short) n1;
		
		System.out.println(n2);
		
		Coche coche= new Coche();
		coche.viajarPorAutopista();
		
		Vehiculo vehiculo= new Vehiculo();
		((Camion)vehiculo).cargar();
		
		

	}

	public static int suma(int a, int b)
	{
		return a + b;
	}

}
