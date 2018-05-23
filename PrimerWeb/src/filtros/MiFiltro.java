package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class MiFiltro
 */
public class MiFiltro implements Filter {

    /**
     * Default constructor. 
     */
    public MiFiltro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//ida
		long t1= System.currentTimeMillis();
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res= (HttpServletResponse) response;
		String nombre=req.getParameter("nombre");
		if(nombre.length()<8)
		{
			res.sendRedirect("error.html");
			return;
		}
		
		chain.doFilter(request, response);
		//vuelta
		long t2= System.currentTimeMillis();
		System.out.println("tiempo:"+(t2-t1));
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
