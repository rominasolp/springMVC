package com.ticketero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ticketero.model.Teatro;

public class TeatroDAOImpl implements TeatroDAO {

	
	private static final Logger logger = LoggerFactory.getLogger(ClienteDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addTeatro(Teatro p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Evento de teatro guardado, detalles="+p);
		
	}

	@Override
	public void updateTeatro(Teatro p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("actualizado correcto => detalle="+p);		
	}

	@Override
	public List<Teatro> listTeatros() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Teatro> lista = session.createQuery("from Teatro").list();
		for(Teatro m : lista){
			logger.info("Lista :"+m);
		}
		
		return lista;
	}

	@Override
	public Teatro getTeatroById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Teatro m = (Teatro) session.load(Teatro.class, new Integer(id));
		logger.info("Teatro, detalle="+m);
		return m;
	}

	@Override
	public void removeTeatro(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Teatro m = (Teatro) session.load(Teatro.class, new Integer(id));
		
		if(null != m){
			session.delete(m);
		}
		logger.info("Teatro borrado, detalle="+m);
		
	}

}
