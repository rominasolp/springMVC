package com.ticketero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ticketero.model.Evento;

@Repository
public class EventoDAOImpl implements EventoDAO {

	private static final Logger logger = LoggerFactory.getLogger(ClienteDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addEvento(Evento p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Evento saved successfully, Evento Details="+p);
		
	}

	@Override
	public void updateEvento(Evento p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);		
		logger.info("Evento updated successfully, Evento Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> listEventos() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Evento> eventsList = session.createQuery("from Evento").list();
		for(Evento p : eventsList){
			logger.info("Evento List::"+p);
		}

		return eventsList;
	}

	@Override
	public Evento getEventoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Evento p = (Evento) session.load(Evento.class, new Integer(id));
		logger.info("Evento loaded successfully, Evento details="+p);
		return p;
	}
	
	@Override
	public void removeEvento(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Evento p = (Evento) session.load(Evento.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Evento deleted successfully, evento details="+p);
	}

}
