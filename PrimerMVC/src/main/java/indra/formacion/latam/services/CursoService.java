package indra.formacion.latam.services;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import indra.formacion.latam.daos.CursoDao;
import indra.formacion.latam.daos.CursoDaoInterface;
import indra.formacion.latam.datos.Cargo;
import indra.formacion.latam.datos.DatoLaboral;
import indra.formacion.latam.datos.DatoPersonal;
import indra.formacion.latam.datos.Empleado;
import indra.formacion.latam.datos.Empresa;
import indra.formacion.latam.datos.Estadocivil;
import indra.formacion.latam.datos.Hijo;
import indra.formacion.latam.delegates.CursoDelegate;

@Service
public class CursoService implements CursoServiceInterface {

	@Autowired
	private CursoDaoInterface cursoDao;
	
	
	@Override
	public void grabaHijo(Hijo hijo) throws Exception {
		getCursoDao().grabaHijo(hijo);
	}

	@Override
	public void grabaEstadoCivil(Estadocivil estadocivil) throws Exception {
		getCursoDao().grabaEstadoCivil(estadocivil);
	}

	@Override
	public void grabaCargo(Cargo cargo) throws Exception {
		getCursoDao().grabaCargo(cargo);

	}

	@Override
	public void grabaDatoPersonal(DatoPersonal datoPersonal) throws Exception {
		getCursoDao().grabaDatoPersonal(datoPersonal);

	}

	@Override
	public void grabaDatoLaboral(DatoLaboral datoLaboral) throws Exception {
		getCursoDao().grabaDatoLaboral(datoLaboral);

	}

	@Override
	public void grabaEmpleado(Empleado empleado) throws Exception {
		getCursoDao().grabaEmpleado(empleado);

	}

	@Override
	public void grabaEmpresa(List<Empleado> empleados) throws Exception {
		getCursoDao().grabaEmpresa(empleados);

	}

	@Override
	public List<Empleado> getEmpresa(int  id) throws Exception {
		
		return getCursoDao().getEmpresa(id);
	}

	@Override
	public List<Empleado> getEmpleados() throws Exception {
		// TODO Auto-generated method stub
		return getCursoDao().getEmpleados();
	}

	@Override
	public List<Cargo> getCargos() throws Exception {
		// TODO Auto-generated method stub
		return getCursoDao().getCargos();
	}

	@Override
	public List<Estadocivil> getEstadoCivil() throws Exception {
		// TODO Auto-generated method stub
		return getCursoDao().getEstadoCivil();
	}

	@Override
	public List<DatoLaboral> getDatoLaboral() throws Exception {
		// TODO Auto-generated method stub
		return getCursoDao().getDatoLaboral();
	}

	@Override
	public List<DatoPersonal> getDatoPersonal() throws Exception {
		// TODO Auto-generated method stub
		return getCursoDao().getDatoPersonal();
	}

	public CursoDaoInterface getCursoDao() {
		return cursoDao;
	}

	public void setCursoDao(CursoDaoInterface cursoDao) {
		this.cursoDao = cursoDao;
	}

	@Override
	public void borraCargo(int id) throws Exception {
		getCursoDao().borraCargo(id);
		
	}

	@Override
	public void borraEstadoCivil(int id) throws Exception {
		getCursoDao().borraEstadoCivil(id);
		
	}

	@Override
	public void borraHijo(int id) throws Exception {
		getCursoDao().borraHijo(id);
		
	}

	@Override
	public void borraDatoLaboral(int id) throws Exception {
		getCursoDao().borraDatoLaboral(id);
		
	}

	@Override
	public void borraDatoPersonal(int id) throws Exception {
		getCursoDao().borraDatoPersonal(id);
		
	}

	@Override
	public void borraEmpleado(int id) throws Exception {
		getCursoDao().borraEmpleado(id);
		
	}

	@Override
	public void borraEmpresa(int id) throws Exception {
		getCursoDao().borraEmpresa(id);
		
	}

	public List<Hijo> getHijos() throws Exception{
	
		return getCursoDao().getHijos();
	}

	public List<Empresa> getEmpresas() throws  Exception {
		
		return getCursoDao().getEmpresas();
	}
@Override 
	public void grabaEmpresaNueva(Empresa empresa)  throws Exception {
	getCursoDao().grabaEmpresaNueva( empresa);
		
	}

}
