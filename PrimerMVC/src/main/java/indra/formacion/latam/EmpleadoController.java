package indra.formacion.latam;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import indra.formacion.latam.datos.Empleado;
import indra.formacion.latam.services.CursoService;

@Controller
public class EmpleadoController {

	@Autowired
	private CursoService cursoService;

	@RequestMapping("empleados")
	public ModelAndView empleados() {
		ModelAndView modelAndView = new ModelAndView("empleados");

		modelAndView.addObject("empleado", new Empleado());

		try {
			modelAndView.addObject("empresas", getCursoService().getEmpresas());
			modelAndView.addObject("datosPersonales", getCursoService().getDatoPersonal());
			modelAndView.addObject("datosLaborales", getCursoService().getDatoLaboral());
			modelAndView.addObject("empleados", getCursoService().getEmpleados());
		} catch (Exception e) {
			modelAndView.addObject("error", "no se ha podido realizar la carga de datos");
			e.printStackTrace();
		}

		return modelAndView;
	}

	@RequestMapping("grabaEmpleado")
	public ModelAndView grabaEmpleado(Empleado empleado) {
		ModelAndView modelAndView = new ModelAndView("empleados");
		modelAndView.addObject("empleado", new Empleado());
		try {
			getCursoService().grabaEmpleado(empleado);
		} catch (Exception e) {
			modelAndView.addObject("error", "la grabacion no se ha realizado");
			e.printStackTrace();
		} finally {
			try {
				modelAndView.addObject("datosLaborales", getCursoService().getDatoLaboral());
				modelAndView.addObject("datosPersonales", getCursoService().getDatoPersonal());
				modelAndView.addObject("empresas", getCursoService().getEmpresas());
				modelAndView.addObject("empleados", getCursoService().getEmpleados());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return modelAndView;
	}

	@RequestMapping("borraEmpleado/{id}")
	public ModelAndView borraEmpleado(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView("empleados");
		modelAndView.addObject("empleado", new Empleado());
		try {
			getCursoService().borraEmpleado(id);
		} catch (Exception e) {
			modelAndView.addObject("error", "el borrado no se ha realizado");
			e.printStackTrace();
		} finally {
			try {
				modelAndView.addObject("datosLaborales", getCursoService().getDatoLaboral());
				modelAndView.addObject("datosPersonales", getCursoService().getDatoPersonal());
				modelAndView.addObject("empresas", getCursoService().getEmpresas());
				modelAndView.addObject("empleados", getCursoService().getEmpleados());
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
