package diauno.primerejercicio;

import diauno.primerejercicio.excepciones.RuedaPinchadaException;
import diauno.primerejercicio.excepciones.SinBateriaException;
import diauno.primerejercicio.excepciones.SinGasolinaException;

public class Coche extends Vehiculo
{
	private boolean gasolina, rueda, bateria;

	public void viajarPorAutopista()
	{
		System.out.println("estoy en la autopista");
	}

	public void arrancar() throws SinGasolinaException, RuedaPinchadaException, SinBateriaException
	{
		if (!gasolina)
			throw new SinGasolinaException();

		if (!rueda)
			throw new RuedaPinchadaException();

		if (!bateria)
			throw new SinBateriaException();

		viajarPorAutopista();
	}

	public boolean isGasolina()
	{
		return gasolina;
	}

	public void setGasolina(boolean gasolina)
	{
		this.gasolina = gasolina;
	}

	public boolean isRueda()
	{
		return rueda;
	}

	public void setRueda(boolean rueda)
	{
		this.rueda = rueda;
	}

	public boolean isBateria()
	{
		return bateria;
	}

	public void setBateria(boolean bateria)
	{
		this.bateria = bateria;
	}

}
