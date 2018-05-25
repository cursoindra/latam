package indra.formacion.latam.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

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
	
	@Override
	public void grabaHijo(Hijo hijo) throws Exception {
		Session session= getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(hijo);
		tx.commit();
		session.close();

	}

	@Override
	public void grabaEstadoCivil(Estadocivil estadocivil) throws Exception {
		Session session= getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(estadocivil);
		tx.commit();
		session.close();

	}

	@Override
	public void grabaCargo(Cargo cargo) throws Exception {
		Session session= getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(cargo);
		tx.commit();
		session.close();

	}

	@Override
	public void grabaDatoPersonal(DatoPersonal datoPersonal) throws Exception {
		Session session= getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(datoPersonal);
		tx.commit();
		session.close();

	}

	@Override
	public void grabaDatoLaboral(DatoLaboral datoLaboral) throws Exception {
		Session session= getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(datoLaboral);
		tx.commit();
		session.close();

	}

	@Override
	public void grabaEmpleado(Empleado empleado) throws Exception {
		Session session= getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(empleado);
		tx.commit();
		session.close();

	}

	@Override
	public void grabaEmpresa(Empresa empresa) throws Exception {
		Session session= getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(empresa);
		tx.commit();
		session.close();

	}

	@Override
	public Empresa getEmpresa(int id)  throws Exception {
		
		//usado con criteria		
		Session session=getSessionFactory().openSession();
		Criteria criteria=session.createCriteria(Empresa.class);
		criteria.add(Restrictions.eq("id", id));
		return (Empresa) criteria.uniqueResult();
	}

	@Override
	public List<Empleado> getEmpleados()  throws Exception {
		//usado con Query (HQL)
		
		Session session= getSessionFactory().openSession();
		Query query= session.createQuery("from Empleado e");
		return query.list();
	}

	@Override
	public List<Cargo> getCargos()  throws Exception {
		//usado con sqlquery
		Session session= getSessionFactory().openSession();
		SQLQuery sqlQuery= session.createSQLQuery("select id,descripcion from cargos");
		List<Cargo> listaCargos= new ArrayList<Cargo>();
		List<Object> listaObjetos=sqlQuery.list();
		
		for (Object object : listaObjetos) {
			Object[] objetos=(Object[]) object;
			Cargo cargo= new Cargo();
			cargo.setId((Integer) objetos[0]);
			cargo.setDescripcion((String) objetos[1]);
			listaCargos.add(cargo);
		}
		//Criteria criteria= session.createCriteria(Cargo.class);
		//return criteria.list();
		return listaCargos;
	}

	@Override
	public List<Estadocivil> getEstadoCivil()  throws Exception {
		Session session= getSessionFactory().openSession();
		Criteria criteria= session.createCriteria(Estadocivil.class);
		return criteria.list();
	}

	

	@Override
	public List<DatoLaboral> getDatoLaboral() throws Exception {
		Session session= getSessionFactory().openSession();
		Criteria criteria= session.createCriteria(DatoLaboral.class);
		return criteria.list();
	}

	@Override
	public List<DatoPersonal> getDatoPersonal() throws Exception {
		Session session= getSessionFactory().openSession();
		Criteria criteria= session.createCriteria(DatoPersonal.class);
		return criteria.list();
	}

	
	
	public SessionFactory getSessionFactory()  throws Exception {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void borraCargo(int id)  throws Exception{
		Session session= getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		Cargo  cargo=(Cargo) session.load(Cargo.class,id);
		session.delete(cargo);
		tx.commit();
		session.close();
		
	}

	@Override
	public void borraEstadoCivil(int id) throws Exception {
		Session session= getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		Estadocivil  estadoCivil=(Estadocivil) session.load(Estadocivil.class,id);
		session.delete(estadoCivil);
		tx.commit();
		session.close();
		
	}

	@Override
	public void borraHijo(int id) throws Exception {
		Session session= getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		Hijo  hijo=(Hijo) session.load(Hijo.class,id);
		session.delete(hijo);
		tx.commit();
		session.close();
		
	}

	@Override
	public void borraDatoLaboral(int id) throws Exception {
		Session session= getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		DatoLaboral  datoLaboral=(DatoLaboral) session.load(DatoLaboral.class,id);
		session.delete(datoLaboral);
		tx.commit();
		session.close();
		
	}

	@Override
	public void borraDatoPersonal(int id) throws Exception {
		Session session= getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		DatoPersonal  datoPersonal=(DatoPersonal) session.load(DatoPersonal.class,id);
		session.delete(datoPersonal);
		tx.commit();
		session.close();
	}

	@Override
	public void borraEmpleado(int id) throws Exception {
		Session session= getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		Empleado  empleado=(Empleado) session.load(Empleado.class,id);
		session.delete(empleado);
		tx.commit();
		session.close();
		
	}

	@Override
	public void borraEmpresa(int id) throws Exception {
		Session session= getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		Empresa  empresa=(Empresa) session.load(Empresa.class,id);
		session.delete(empresa);
		tx.commit();
		session.close();
		
	}

	public List<Hijo> getHijos() throws  Exception {
		Session session= getSessionFactory().openSession();
		Criteria criteria= session.createCriteria(Hijo.class);
		return criteria.list();
	}

	public List<Empresa> getEmpresas() throws  Exception {
		Session session=getSessionFactory().openSession();
		Criteria criteria= session.createCriteria(Empresa.class);
		
		return criteria.list();
	}
}
