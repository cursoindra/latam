package indra.formacion.latam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import indra.formacion.latam.datos.Estadocivil;
import indra.formacion.latam.services.CursoService;

@Controller
public class EstadoCivilController {
	@Autowired
	private CursoService cursoService;
	
	@RequestMapping("estadoCivil")
	public ModelAndView estadoCivil() 
	{
		ModelAndView modelAndView= new ModelAndView("estadoCivil");
		modelAndView.addObject("estadoCivil",new Estadocivil());
		try {
			modelAndView.addObject("estadosCiviles", getCursoService().getEstadoCivil());
		} catch (Exception e) {
			modelAndView.addObject("error", "no se ha podido realizar la carga de datos");
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	@RequestMapping("grabaEstadoCivil")
	public ModelAndView grabaEstadoCivil(Estadocivil estadocivil)
	{
		ModelAndView modelAndView= new ModelAndView("estadoCivil");
		
		try {
			getCursoService().grabaEstadoCivil(estadocivil);
			modelAndView.addObject("estadoCivil",new Estadocivil());
			modelAndView.addObject("estadosCiviles", getCursoService().getEstadoCivil());
		} catch (Exception e) {
			
			e.printStackTrace();
			modelAndView.addObject("error","la grabacion no se ha realizado");
		}
		
		return estadoCivil();
		
	}
	
	@RequestMapping("borraEstadoCivil/{id}")
	public ModelAndView borraEstadoCivil(@PathVariable("id") int id)
	{
		ModelAndView modelAndView= new ModelAndView("estadoCivil");
		try {
			getCursoService().borraEstadoCivil(id);
			modelAndView.addObject("estadoCivil",new Estadocivil());
			modelAndView.addObject("estadosCiviles", getCursoService().getEstadoCivil());
		} catch (Exception e) {
			modelAndView.addObject("error","el borrado no se ha realizado");
			e.printStackTrace();
		}
		
		return modelAndView;
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

}
