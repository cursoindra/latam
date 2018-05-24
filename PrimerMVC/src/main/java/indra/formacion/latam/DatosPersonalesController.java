package indra.formacion.latam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.tools.xjc.reader.RawTypeSet.Mode;

import indra.formacion.latam.datos.DatoPersonal;
import indra.formacion.latam.services.CursoService;

@Controller
public class DatosPersonalesController {
	@Autowired
	private CursoService cursoService;
	
	@RequestMapping("datosPersonales")
	public ModelAndView datosPersonales()
	{
		ModelAndView modelAndView= new ModelAndView("datosPersonales");
		
		modelAndView.addObject("datoPersonal", new DatoPersonal());
		
		try {
			modelAndView.addObject("estadosCiviles", getCursoService().getEstadoCivil());
			modelAndView.addObject("hijos", getCursoService().getHijos());
			modelAndView.addObject("datosPersonales", getCursoService().getDatoPersonal());
		} catch (Exception e) {
			modelAndView.addObject("error", "no se ha podido realizar la carga de datos");
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	@RequestMapping("grabaDatoPersonal")
	public ModelAndView grabaDatoPersonal(DatoPersonal datoPersonal)
	{
		ModelAndView modelAndView= new ModelAndView("datosPersonales");
		modelAndView.addObject("datoPersonal", new DatoPersonal());
	
		try {
			getCursoService().grabaDatoPersonal(datoPersonal);
		} catch (Exception e) {
			modelAndView.addObject("error","la grabacion no se ha realizado");
			e.printStackTrace();
		}
		finally {
			try {
				modelAndView.addObject("hijos",	getCursoService().getHijos());
				modelAndView.addObject("estadosCiviles", getCursoService().getEstadoCivil());
				modelAndView.addObject("datosPersonales", getCursoService().getDatoPersonal());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return modelAndView;
	}
	
	@RequestMapping("borraDatoPersonal/{id}")
	public ModelAndView borraDatoPersonal(@PathVariable("id") int id)
	{
		ModelAndView modelAndView= new ModelAndView("datosPersonales");
		modelAndView.addObject("datoPersonal", new DatoPersonal());
		try {
			getCursoService().borraDatoPersonal(id);
		} catch (Exception e) {
			modelAndView.addObject("error","el borrado no se ha realizado");
			e.printStackTrace();
		}
		finally {
			try {
				modelAndView.addObject("datosPersonales", getCursoService().getDatoPersonal());
				modelAndView.addObject("hijos", getCursoService().getHijos());
				modelAndView.addObject("estadosCiviles", getCursoService().getEstadoCivil());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
