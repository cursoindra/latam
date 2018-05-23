package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MayusculasTag extends TagSupport {
	private String texto;
	
	@Override
	public int doStartTag() throws JspException {
		
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		
		try {
			pageContext.getOut().println(getTexto().toUpperCase());
		} catch (IOException e) {
			return SKIP_PAGE;
		}
		return EVAL_PAGE;
	}
	

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	

}
