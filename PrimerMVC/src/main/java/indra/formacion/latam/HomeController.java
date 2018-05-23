package indra.formacion.latam;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.events.NotationDeclaration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import indra.formacion.latam.beans.Login;
import indra.formacion.latam.datos.Cargo;
import indra.formacion.latam.delegates.CursoDelegate;
import indra.formacion.latam.services.CursoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private CursoDelegate cursoDelegate;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private Login login;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {	
		
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.setViewName("home");
		
		modelAndView.addObject("login", new Login());
		return modelAndView;
	}
	
	@RequestMapping("/primeraPrueba")
	public ModelAndView verNombre(@RequestParam("nombre") String nombre)
	{
		ModelAndView modelAndView= new ModelAndView("home");
		
		String resultado="has escrito "+nombre.toUpperCase()+" y tiene "+nombre.length()+" letras";
		modelAndView.addObject("resultado",resultado);
		return modelAndView;
	}
	
	@RequestMapping("/primeraPruebaAntiguo")	
	public ModelAndView verAntiguo(HttpServletRequest request )
	{
		ModelAndView modelAndView= new ModelAndView("home");
		String nombre=request.getParameter("nombre");
		String resultado="has escrito "+nombre.toUpperCase()+" y tiene "+nombre.length()+" letras en antiguo";
		modelAndView.addObject("resultado",resultado);
		return modelAndView;
	}
	
	@RequestMapping("/login")	
	public ModelAndView login(@RequestParam("usuario") String usuario, @RequestParam("clave") String clave)
	{
		ModelAndView modelAndView= new ModelAndView("home");
		getCursoDelegate().login(usuario, clave);
		if(getLogin().getUsuario().equals("javier") 
				&& getLogin().getClave().equals("1234"))
		{
			modelAndView.addObject("resultado", "El usuario y la clave son correctos");
		}
		else
		{
			modelAndView.addObject("resultado", "El usuario y la clave son no correctos");
		}
		
		return modelAndView;
	}
	
	@RequestMapping("loginObjeto")
	public ModelAndView loginObjeto(Login login)
	{
		ModelAndView modelAndView= new ModelAndView("home");
		if(login.getUsuario().equals("javier") && login.getClave().equals("1234"))
		{
			modelAndView.addObject("resultado", "Has acertado!!!!!");
		}
		else
		{
			modelAndView.addObject("resultado","No has dado ni una!!!");
		}
		
		return modelAndView;
	}
	
	@RequestMapping("loginFriendly/{usuario}/{clave}")
	public ModelAndView loginFriendly(@PathVariable("usuario") String usuario,@PathVariable("clave") String clave)
	{
		ModelAndView modelAndView= new ModelAndView("home");
		if(usuario.equals("javier") && clave.equals("1234"))
		{
			modelAndView.addObject("resultado", "Bien, has entrado con url friendly");
		}
		else
		{
			modelAndView.addObject("resultado", "no has entrado ni con url friendly");
		}
		
		return modelAndView;
	}
	
	
	@RequestMapping("altaCargos")
	public ModelAndView altacargo()
	{
		ModelAndView modelAndView= new ModelAndView("altaCargos");
		modelAndView.addObject("cargo", new Cargo());
		
		try {
			modelAndView.addObject("cargos", getCursoService().getCargos());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			modelAndView.addObject("error", "no se ha podido realizar la carga de datos");
		
		}
		
		return modelAndView;
	}
	
	
	@RequestMapping("grabaCargo")
	public ModelAndView grabaCargo(Cargo cargo)
	{
		ModelAndView modelAndView= new ModelAndView("altaCargos");
		
		try {
			getCursoService().grabaCargo(cargo);
			modelAndView.addObject("cargos", getCursoService().getCargos());
			modelAndView.addObject("cargo",new Cargo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			modelAndView.addObject("error","la grabacion no se ha realizado");
		}
		
		
		return modelAndView;
	}
	
	
	@RequestMapping("borraCargo/{id}")
	public ModelAndView borraCargo(@PathVariable("id") int id)
	{
		ModelAndView modelAndView= new ModelAndView("altaCargos");
		
		try {
			getCursoService().borraCargo(id);
			modelAndView.addObject("cargos", getCursoService().getCargos());
			modelAndView.addObject("cargo",new Cargo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			modelAndView.addObject("error","el borrado no se ha realizado");
		}
		
		return modelAndView;
		
	}
	
	
	public CursoDelegate getCursoDelegate() {
		return cursoDelegate;
	}

	public void setCursoDelegate(CursoDelegate cursoDelegate) {
		this.cursoDelegate = cursoDelegate;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}
	
}
