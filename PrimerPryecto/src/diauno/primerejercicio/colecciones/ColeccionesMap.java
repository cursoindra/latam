package diauno.primerejercicio.colecciones;

import java.util.HashMap;
import java.util.Map;

public class ColeccionesMap
{

	public static void main(String[] args)
	{
		Map<String, String> mapa = new HashMap<>();
		mapa.put("nombre", "javier");
		mapa.put("direccion", "mi casa");
		mapa.put("edad", "37");
		mapa.put("portal", "37");
		mapa.put("portal", "37");
		mapa.put("portal", "37");
		mapa.put("portal", "37");
		mapa.put("portal", "37");
		mapa.put("portal", "37");

		for (String key : mapa.keySet())
		{
			System.out.println(key + ":" + mapa.get(key));
		}

	}

}
