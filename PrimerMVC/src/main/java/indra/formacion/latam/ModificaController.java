package indra.formacion.latam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import indra.formacion.latam.datos.Empresa;
import indra.formacion.latam.services.CursoService;

@Controller
public class ModificaController {
	
	@Autowired
	private CursoService cursoService;
	
	@RequestMapping("modificacion")
	public ModelAndView modificacion()
	{
		ModelAndView modelAndView= new ModelAndView("modificacion");
		modelAndView.addObject("empresa", new Empresa());
		modelAndView.addObject("empresaModificada", new Empresa());
		try {
			modelAndView.addObject("empresas", getCursoService().getEmpresas());
		} catch (Exception e) {
			modelAndView.addObject("error", "no se ha podido realizar la carga de datos");
			e.printStackTrace();
		}
		
		return modelAndView;
	}

	@RequestMapping("modificaEmpresa")
	public ModelAndView modificaEmpresa(Empresa empresa)
	{
		ModelAndView modelAndView= new ModelAndView("modificacion");
		
		try {
			Empresa empresaModificada= new Empresa();
			empresaModificada.setEmpleados(getCursoService().getEmpresa(empresa.getId()));
			
			modelAndView.addObject("empresaModificada", empresaModificada);
		} catch (Exception e) {
			modelAndView.addObject("error", "no se ha podido realizar la carga de datos");
			e.printStackTrace();
		}
		finally {
			try {
				modelAndView.addObject("datosLaborales", getCursoService().getDatoLaboral());
				modelAndView.addObject("datosPersonales",getCursoService().getDatoPersonal());
				modelAndView.addObject("empresas", getCursoService().getEmpresas());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return modelAndView;
		
	}
	
	
	@RequestMapping("grabaEmpresaModificada")
	public ModelAndView grabaEmpresaModificada(Empresa empresa)
	{
		ModelAndView modelAndView= new ModelAndView("modificacion");
		
		try {
			getCursoService().grabaEmpresa(empresa.getEmpleados());
		} catch (Exception e) {
			modelAndView.addObject("error","la grabacion no se ha realizado");
			e.printStackTrace();
		}
		finally {
			try {
				modelAndView.addObject("datosLaborales", getCursoService().getDatoLaboral());
				modelAndView.addObject("datosPersonales",getCursoService().getDatoPersonal());
				modelAndView.addObject("empresas", getCursoService().getEmpresas());
				modelAndView.addObject("empresa", new Empresa());
				empresa.setEmpleados(getCursoService().getEmpresa(empresa.getEmpleados().get(0).getEmpresa().getId()));
				
				modelAndView.addObject("empresaModificada", empresa);
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
