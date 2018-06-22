package com.ticketero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ticketero.model.Deporte;

public class DeporteDAOImpl implements DeporteDAO {

	private static final Logger logger = LoggerFactory.getLogger(ClienteDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addDeporte(Deporte p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Evento de deporte guardado, detalles="+p);		
	}

	@Override
	public void updateDeporte(Deporte p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("actualizado correcto => detalle="+p);
		
	}

	@Override
	public List<Deporte> listDeportes() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Deporte> lista = session.createQuery("from Deporte").list();
		for(Deporte m : lista){
			logger.info("Lista :"+m);
		}
		
		return lista;
	}

	@Override
	public Deporte getDeporteById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Deporte m = (Deporte) session.load(Deporte.class, new Integer(id));
		logger.info("Deporte, detalle="+m);
		return m;
	}

	@Override
	public void removeDeporte(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Deporte m = (Deporte) session.load(Deporte.class, new Integer(id));
		
		if(null != m){
			session.delete(m);
		}
		logger.info("Deporte borrado, detalle="+m);
		
	}
	

}
