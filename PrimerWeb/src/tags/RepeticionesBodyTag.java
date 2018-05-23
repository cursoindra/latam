package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class RepeticionesBodyTag extends BodyTagSupport {
	
	private String texto;
	private int cantidad,contador;
	
	@Override
	public int doStartTag() throws JspException {
		setContador(0);
		return EVAL_BODY_BUFFERED;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		setContador(getContador()+1);
		if(getContador()<=getCantidad())
		{
			
				return EVAL_BODY_AGAIN;
			
		}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		try {
			getBodyContent().writeOut(getPreviousOut());
			return EVAL_PAGE;
		} catch (IOException e) {
			return SKIP_PAGE;
		}
	}
	
	
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}

}
