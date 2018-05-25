package indra.formacion.latam;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import indra.formacion.latam.datos.Empresa;
import indra.formacion.latam.services.CursoService;

@Controller
public class EmpresasController {

	@Autowired
	private CursoService cursoService;
	
	@RequestMapping("empresas")
	public ModelAndView empresas()
	{
		ModelAndView modelAndView= new ModelAndView("empresas");
		modelAndView.addObject("empresa", new Empresa());
		try {
			modelAndView.addObject("empresas", getCursoService().getEmpresas());
		} catch (HibernateException e) {
			modelAndView.addObject("error", "no se ha podido realizar la carga de datos");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	
	@RequestMapping("grabaEmpresa")
	public ModelAndView grabaEmpresa(Empresa empresa)
	{
		ModelAndView modelAndView= new ModelAndView("empresas");
		modelAndView.addObject("empresa", new Empresa());
		
		try {
			getCursoService().grabaEmpresa(empresa);
			
		} catch (Exception e) {
			modelAndView.addObject("error","la grabacion no se ha realizado");
			e.printStackTrace();
		}
		finally {
			try {
				modelAndView.addObject("empresas", getCursoService().getEmpresas());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return modelAndView;
	}
	
	@RequestMapping("borraEmpresa/{id}")
	public ModelAndView borraEmpresa(@PathVariable("id") int id){	
		ModelAndView modelAndView= new ModelAndView("empresas");
		
		try {
			getCursoService().borraEmpresa(id);
			
		} catch (Exception e) {
			modelAndView.addObject("error","el borrado no se ha realizado");
			e.printStackTrace();
		}
		finally {
			modelAndView.addObject("empresa", new Empresa());
			try {
				modelAndView.addObject("empresas", getCursoService().getEmpresas());
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
