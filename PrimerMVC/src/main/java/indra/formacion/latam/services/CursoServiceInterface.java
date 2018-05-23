package indra.formacion.latam.services;

import java.util.List;

import indra.formacion.latam.datos.Cargo;
import indra.formacion.latam.datos.DatoLaboral;
import indra.formacion.latam.datos.DatoPersonal;
import indra.formacion.latam.datos.Empleado;
import indra.formacion.latam.datos.Empresa;
import indra.formacion.latam.datos.Estadocivil;
import indra.formacion.latam.datos.Hijo;

public interface CursoServiceInterface {
	
	public void grabaHijo(Hijo hijo) throws Exception;
	public void grabaEstadoCivil(Estadocivil estadocivil) throws Exception;
	public void grabaCargo(Cargo cargo) throws Exception;
	public void grabaDatoPersonal(DatoPersonal datoPersonal) throws Exception;
	public void grabaDatoLaboral(DatoLaboral datoLaboral) throws Exception;
	public void grabaEmpleado(Empleado empleado) throws Exception;
	public void grabaEmpresa(Empresa empresa) throws Exception;
	
	public Empresa getEmpresa(String nombre) throws Exception ;
	public List<Empleado> getEmpleados() throws Exception ;
	public List<Cargo> getCargos() throws Exception ;
	public List<Estadocivil> getEstadoCivil() throws Exception ;
	public List<DatoLaboral> getDatoLaboral() throws Exception ;
	public List<DatoPersonal> getDatoPersonal() throws Exception ;
	void borraCargo( int id) throws Exception;
	public void borraEstadoCivil(int id) throws Exception;
	public void borraHijo(int id) throws Exception;
	public void borraDatoLaboral(int id) throws Exception;
	public void borraDatoPersonal(int id) throws Exception;
	public void borraEmpleado(int id) throws Exception;
	public void borraEmpresa(int id) throws Exception;

}