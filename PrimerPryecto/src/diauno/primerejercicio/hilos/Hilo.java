package diauno.primerejercicio.hilos;

public class Hilo extends Thread
{
	
	private int inicio,tiempo;
	
	public Hilo(int inicio, int tiempo)
	{
		this.inicio=inicio;
		this.tiempo=tiempo;
	}

	public void run()
	{
	
		
		while(true)
		{
			setInicio(getInicio()+1);
			System.out.println(getInicio());
			 try
			{
				Thread.sleep(getTiempo());
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int getInicio()
	{
		return inicio;
	}

	public void setInicio(int inicio)
	{
		this.inicio = inicio;
	}

	public int getTiempo()
	{
		return tiempo;
	}

	public void setTiempo(int tiempo)
	{
		this.tiempo = tiempo;
	}

}
