package indra.formacion.latam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import indra.formacion.latam.datos.Hijo;
import indra.formacion.latam.services.CursoService;

@Controller
public class HijosController {

	@Autowired
	private CursoService cursoService;

	@RequestMapping("hijos")
	public ModelAndView hijos() {
		ModelAndView modelAndView = new ModelAndView("hijos");

		modelAndView.addObject("hijo", new Hijo());
		try {
			modelAndView.addObject("hijos", getCursoService().getHijos());
		} catch (Exception e) {
			modelAndView.addObject("error", "no se ha podido realizar la carga de datos");
			e.printStackTrace();
		}

		return modelAndView;
	}

	@RequestMapping("grabaHijo")
	public ModelAndView grabaHijo(Hijo hijo) {
		ModelAndView modelAndView = new ModelAndView("hijos");
		modelAndView.addObject("hijo", new Hijo());

		try {
			getCursoService().grabaHijo(hijo);
			modelAndView.addObject("error", "Hijo grabado correctamente");

		} catch (Exception e) {
			modelAndView.addObject("error", "El hijo no se ha grabado");
			e.printStackTrace();
		} finally {
			try {
				modelAndView.addObject("hijos", getCursoService().getHijos());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return modelAndView;
	}

	@RequestMapping("borraHijo.html")
	public ModelAndView borraHijo(@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView("hijos");
		try {
			getCursoService().borraHijo(id);
			modelAndView.addObject("hijos", getCursoService().getHijos());
		} catch (Exception e) {
			modelAndView.addObject("error", "no se ha podido realizar la carga de datos");
			e.printStackTrace();
		}
		finally {
			modelAndView.addObject("hijo", new Hijo());
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
