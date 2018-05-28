package indra.formacion.latam.aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import indra.formacion.latam.daos.CursoDao;

@Component
@Aspect
public class SessionManager {

	@Pointcut("execution(@indra.formacion.latam.anotaciones.Vigilado  * *.*(..))")
	public void sujetador()
	{
		
	}
	
	@Around("sujetador()")
	public Object vigilar(ProceedingJoinPoint joinPoint)
	{
		Object salida=null;
		
		CursoDao cursoDao=(CursoDao) joinPoint.getTarget();
		
		try {
			//Before
			if(cursoDao.getSession()==null || !cursoDao.getSession().isOpen())
				cursoDao.setSession(cursoDao.getSessionFactory().openSession());
			salida=joinPoint.proceed();
			//AfterReturning
		} catch (Throwable e) {
			//AfterThrowing
			e.printStackTrace();
		}
		finally {
			cursoDao.getSession().close();
		}
		//After
		
		return salida;
	}
	
}
