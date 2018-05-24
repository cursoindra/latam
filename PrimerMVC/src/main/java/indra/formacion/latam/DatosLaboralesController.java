package indra.formacion.latam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import indra.formacion.latam.datos.DatoLaboral;
import indra.formacion.latam.services.CursoService;

@Controller
public class DatosLaboralesController {
	
	@Autowired
	private CursoService cursoService;
	@RequestMapping("datosLaborales")
	public ModelAndView datosLaborales()
	{
		ModelAndView modelAndView= new ModelAndView("datosLaborales");
		modelAndView.addObject("datoLaboral", new DatoLaboral());
		
		try {
			modelAndView.addObject("datosLaborales",getCursoService().getDatoLaboral());
			modelAndView.addObject("cargos", getCursoService().getCargos());
		} catch (Exception e) {
			modelAndView.addObject("error", "no se ha podido realizar la carga de datos");
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	@RequestMapping("grabaDatoLaboral")
	public ModelAndView grabaDatoLaboral(DatoLaboral datoLaboral)
	{
		ModelAndView modelAndView= new ModelAndView("datosLaborales");
		modelAndView.addObject("datoLaboral", new DatoLaboral());
		try {
			getCursoService().grabaDatoLaboral(datoLaboral);
		} catch (Exception e) {
			modelAndView.addObject("error","la grabacion no se ha realizado");
			e.printStackTrace();
		}
		finally {
			try {
				modelAndView.addObject("datosLaborales",getCursoService().getDatoLaboral());
				modelAndView.addObject("cargos", getCursoService().getCargos());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return modelAndView;
		
	}
	
	@RequestMapping("borraDatoLaboral/{id}")
	public ModelAndView borraDatoLaborel(@PathVariable("id") int id)
	{
		ModelAndView modelAndView= new ModelAndView("datosLaborales");
		modelAndView.addObject("datoLaboral", new DatoLaboral());
		try {
			getCursoService().borraDatoLaboral(id);
			modelAndView.addObject("cargos", getCursoService().getCargos());
			modelAndView.addObject("datosLaborales", getCursoService().getDatoLaboral());
			
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
