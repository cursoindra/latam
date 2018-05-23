/**
 * 
 */
package curso.java.concierto.excepciones;

/**
 * @author javierdiaz
 * @version 1.0
 * @since 1.8
 */
public class InstrumentoRotoException extends Exception
{
	
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = -9195339744713752851L;

	public void avisarAlPublico()
	{


		System.out.println("SEÑORES SE HA ACABADO EL CONCIERTO, EN LA PUERTA LES DEVUELVEN EL DINERO");
		
	}

}
