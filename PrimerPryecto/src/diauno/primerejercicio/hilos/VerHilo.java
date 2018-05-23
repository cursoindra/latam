package diauno.primerejercicio.hilos;

public class VerHilo
{

	public static void main(String[] args)
	{
		Hilo hilo= new Hilo(5000,200);
		hilo.start();
		
		Hilo hilo1= new Hilo(10000,400);
		hilo1.start();
		
		Hilo hilo2= new Hilo(20000,800);
		hilo2.start();
		
		Hilo hilo3= new Hilo(30000,1000);
		hilo3.start();
		
		Hilo hilo4= new Hilo(40000,2000);
		hilo4.start();
	}

}
