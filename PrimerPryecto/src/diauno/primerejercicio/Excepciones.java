package diauno.primerejercicio;

import diauno.primerejercicio.excepciones.RuedaPinchadaException;
import diauno.primerejercicio.excepciones.SinBateriaException;
import diauno.primerejercicio.excepciones.SinGasolinaException;

public class Excepciones
{

	public static void main(String[] args) throws SinGasolinaException, RuedaPinchadaException, SinBateriaException
	{
		Coche coche= new Coche();
		try
		{
			coche.setGasolina(true);
			coche.setBateria(false);
			coche.setRueda(false);
			coche.arrancar();
			
		} catch (SinGasolinaException e)
		{
			System.out.println("estoy sin gasolina");
			coche.setGasolina(true);
			System.out.println("he repostado");
			coche.arrancar();
		} catch (RuedaPinchadaException e)
		{
			System.out.println("tienes la rueda pinchada");
			coche.setRueda(true);
			System.out.println("he cambiado la rueda");
			coche.arrancar();
		} catch (SinBateriaException e)
		{
			System.out.println("no tienes bateria");
			coche.setBateria(true);
			System.out.println("he cargado la bateria");
			coche.arrancar();
		}

	}

}
