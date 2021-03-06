package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ResultadoTag extends TagSupport{
	
	
	@Override
	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		
		RepeticionesBodyTag papa=(RepeticionesBodyTag) getParent();
		
		try {
			pageContext.getOut().println(papa.getTexto().toUpperCase());
		} catch (IOException e) {
			return SKIP_PAGE;
		}
		
		return EVAL_PAGE;
	}

}
