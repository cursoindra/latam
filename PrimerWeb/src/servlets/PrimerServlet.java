package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PrimerServlet
 */
public class PrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int contador;
	
    /**
     * Default constructor. 
     */
    public PrimerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*String nombre=request.getParameter("nombre");
		String resultado="<h1>Has escrito "+nombre.toUpperCase()+" y tiene "+nombre.length()+" letras</h1>";
		response.getWriter().println(resultado);
		response.getWriter().flush();*/
		
		setContador(getContador()+1);
		
		String usuario= request.getParameter("usuario");
		String clave= request.getParameter("clave");
		
		if(usuario.equals("javier") && clave.equals("1234"))
		{
			response.getWriter().println("<h1>usuario correcto</h1>");
		}
		else
		{
			response.getWriter().println("<h1 style=\"color:#ff0000\">el usuario o la clave no son correctos, vuelva a intentarlo</h1>");
		}
		
		
		response.getWriter().println("<h1 style=\"color:#00ff00\">ERES EL VISITANTE NUMERO:"+getContador()+"</h1>");
		
		HttpSession session= request.getSession(true);
		
		if(session.getAttribute("visitas")==null)
		{
			session.setAttribute("visitas", 1);
		}
		else
		{
			int visitas=(Integer) session.getAttribute("visitas");
			visitas++;
			session.setAttribute("visitas", visitas);
		}
		
		response.getWriter().println("<h1 style=\"color:#0000FF\">TU HAS VENIDO A VERME:"+session.getAttribute("visitas")+"</h1>");
		
		response.getWriter().flush();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	public int getContador()
	{
		return contador;
	}

	public void setContador(int contador)
	{
		this.contador = contador;
	}

}
