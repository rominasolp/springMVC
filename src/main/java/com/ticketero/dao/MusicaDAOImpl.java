package com.ticketero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ticketero.model.Musica;

public class MusicaDAOImpl implements MusicaDAO {

	private static final Logger logger = LoggerFactory.getLogger(ClienteDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addMusica(Musica p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Evento de música guardada, detalles="+p);
		
	}

	@Override
	public void updateMusica(Musica p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("actualizado correcto => detalle="+p);
				
	}

	@Override
	public List<Musica> listMusicas() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Musica> lista = session.createQuery("from Musica").list();
		for(Musica m : lista){
			logger.info("Lista :"+m);
		}
		
		return lista;
	}

	@Override
	public Musica getMusicaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Musica m = (Musica) session.load(Musica.class, new Integer(id));
		logger.info("Musica, detalle="+m);
		return m;
	}

	@Override
	public void removeMusica(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Musica m = (Musica) session.load(Musica.class, new Integer(id));
		
		if(null != m){
			session.delete(m);
		}
		logger.info("Musica borrada, detalle="+m);		
		
	}

}
