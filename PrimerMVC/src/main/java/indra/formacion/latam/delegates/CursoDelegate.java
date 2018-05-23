package indra.formacion.latam.delegates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import indra.formacion.latam.beans.Login;

@Component
public class CursoDelegate {

	
	
	@Autowired
	private Login login;
	
	public void login(String usuario, String clave)
	{
		
		getLogin().setUsuario(usuario);
		getLogin().setClave(clave);
		
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
}
