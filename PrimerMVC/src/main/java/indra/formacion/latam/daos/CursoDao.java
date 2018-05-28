package indra.formacion.latam.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import indra.formacion.latam.anotaciones.Vigilado;
import indra.formacion.latam.datos.Cargo;
import indra.formacion.latam.datos.DatoLaboral;
import indra.formacion.latam.datos.DatoPersonal;
import indra.formacion.latam.datos.Empleado;
import indra.formacion.latam.datos.Empresa;
import indra.formacion.latam.datos.Estadocivil;
import indra.formacion.latam.datos.Hijo;

@Repository
public class CursoDao implements CursoDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session;

	@Override
	@Vigilado
	public void grabaHijo(Hijo hijo) throws Exception {

		Transaction tx = getSession().beginTransaction();
		getSession().saveOrUpdate(hijo);
		tx.commit();

	}

	@Override
	@Vigilado
	public void grabaEstadoCivil(Estadocivil estadocivil) throws Exception {
		Transaction tx = getSession().beginTransaction();
		getSession().saveOrUpdate(estadocivil);
		tx.commit();

	}

	@Override
	@Vigilado
	public void grabaCargo(Cargo cargo) throws Exception {
		Transaction tx = getSession().beginTransaction();
		getSession().saveOrUpdate(cargo);
		tx.commit();

	}

	@Override
	@Vigilado
	public void grabaDatoPersonal(DatoPersonal datoPersonal) throws Exception {
		Transaction tx = getSession().beginTransaction();
		getSession().saveOrUpdate(datoPersonal);
		tx.commit();

	}

	@Override
	@Vigilado
	public void grabaDatoLaboral(DatoLaboral datoLaboral) throws Exception {

		Transaction tx = getSession().beginTransaction();
		getSession().saveOrUpdate(datoLaboral);
		tx.commit();

	}

	@Override
	@Vigilado
	public void grabaEmpleado(Empleado empleado) throws Exception {
		Transaction tx = getSession().beginTransaction();
		getSession().saveOrUpdate(empleado);
		tx.commit();

	}

	@Override
	@Vigilado
	public void grabaEmpresa(List<Empleado> empleados) throws Exception {

		Transaction tx = getSession().beginTransaction();
		for (Empleado empleado : empleados) {

			getSession().update(empleado);
		}

		tx.commit();

	}

	@Override
	@Vigilado
	public List<Empleado> getEmpresa(int id) throws Exception {

		// usado con criteria
		Criteria criteria = getSession().createCriteria(Empleado.class);
		criteria.add(Restrictions.eq("empresa.id", id));
		List<Empleado> empleados = (List<Empleado>) criteria.list();

		return empleados;
	}

	@Override
	@Vigilado
	public List<Empleado> getEmpleados() throws Exception {
		// usado con Query (HQL)

		Query query = getSession().createQuery("from Empleado e");
		List<Empleado> empleados = query.list();

		return empleados;
	}

	@Override
	@Vigilado
	public List<Cargo> getCargos() throws Exception {
		// usado con sqlquery

		SQLQuery sqlQuery = getSession().createSQLQuery("select id,descripcion from cargos");
		List<Cargo> listaCargos = new ArrayList<Cargo>();
		List<Object> listaObjetos = sqlQuery.list();

		for (Object object : listaObjetos) {
			Object[] objetos = (Object[]) object;
			Cargo cargo = new Cargo();
			cargo.setId((Integer) objetos[0]);
			cargo.setDescripcion((String) objetos[1]);
			listaCargos.add(cargo);
		}

		return listaCargos;
	}

	@Override
	@Vigilado
	public List<Estadocivil> getEstadoCivil() throws Exception {

		Criteria criteria = getSession().createCriteria(Estadocivil.class);
		List<Estadocivil> estadosCiviles = criteria.list();

		return estadosCiviles;
	}

	@Override
	@Vigilado
	public List<DatoLaboral> getDatoLaboral() throws Exception {

		Criteria criteria = getSession().createCriteria(DatoLaboral.class);
		List<DatoLaboral> datosLaborales = criteria.list();

		return datosLaborales;
	}

	@Override
	@Vigilado
	public List<DatoPersonal> getDatoPersonal() throws Exception {

		Criteria criteria = getSession().createCriteria(DatoPersonal.class);
		List<DatoPersonal> datosPersonales = criteria.list();

		return datosPersonales;
	}

	@Override
	@Vigilado
	public void borraCargo(int id) throws Exception {

		Transaction tx = getSession().beginTransaction();
		Cargo cargo = (Cargo) getSession().load(Cargo.class, id);
		getSession().delete(cargo);
		tx.commit();

	}

	@Override
	@Vigilado
	public void borraEstadoCivil(int id) throws Exception {

		Transaction tx = getSession().beginTransaction();
		Estadocivil estadoCivil = (Estadocivil) getSession().load(Estadocivil.class, id);
		getSession().delete(estadoCivil);
		tx.commit();

	}

	@Override
	@Vigilado
	public void borraHijo(int id) throws Exception {

		Transaction tx = getSession().beginTransaction();
		Hijo hijo = (Hijo) getSession().load(Hijo.class, id);
		getSession().delete(hijo);
		tx.commit();

	}

	@Override
	@Vigilado
	public void borraDatoLaboral(int id) throws Exception {

		Transaction tx = getSession().beginTransaction();
		DatoLaboral datoLaboral = (DatoLaboral) getSession().load(DatoLaboral.class, id);
		getSession().delete(datoLaboral);
		tx.commit();

	}

	@Override
	@Vigilado
	public void borraDatoPersonal(int id) throws Exception {

		Transaction tx = getSession().beginTransaction();
		DatoPersonal datoPersonal = (DatoPersonal) getSession().load(DatoPersonal.class, id);
		getSession().delete(datoPersonal);
		tx.commit();

	}

	@Override
	@Vigilado
	public void borraEmpleado(int id) throws Exception {

		Transaction tx = session.beginTransaction();
		Empleado empleado = (Empleado) session.load(Empleado.class, id);
		session.delete(empleado);
		tx.commit();

	}

	@Override
	@Vigilado
	public void borraEmpresa(int id) throws Exception {

		Transaction tx = getSession().beginTransaction();
		Empresa empresa = (Empresa) getSession().load(Empresa.class, id);
		getSession().delete(empresa);
		tx.commit();

	}

	@Override
	@Vigilado
	public List<Hijo> getHijos() throws Exception {

		Criteria criteria = getSession().createCriteria(Hijo.class);
		List<Hijo> hijos = criteria.list();

		return hijos;
	}

	@Override
	@Vigilado
	public List<Empresa> getEmpresas() throws Exception {
		
		Criteria criteria = getSession().createCriteria(Empresa.class);
		List<Empresa> empresas = criteria.list();
		return empresas;
	}

	@Override
	@Vigilado
	public List<Empleado> getEmpleados(int id) throws Exception {
		
		Criteria criteria = getSession().createCriteria(Empleado.class);
		criteria.add(Restrictions.isNotNull("empresa")).createCriteria("empresa").add(Restrictions.eq("id", id));
		List<Empleado> empleados = criteria.list();
		return empleados;
	}

	@Override
	@Vigilado
	public void grabaEmpresaNueva(Empresa empresa) throws Exception {
		Transaction tx = getSession().beginTransaction();

		getSession().saveOrUpdate(empresa);
		tx.commit();

	}

	public SessionFactory getSessionFactory() throws Exception {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
}
