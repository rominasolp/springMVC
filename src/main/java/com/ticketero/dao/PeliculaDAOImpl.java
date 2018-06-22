package com.ticketero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ticketero.model.Pelicula;

public class PeliculaDAOImpl implements PeliculaDAO {

	private static final Logger logger = LoggerFactory.getLogger(ClienteDAOImpl.class);

	private SessionFactory sessionFactory;
	
	@Override
	public void addPelicula(Pelicula p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Evento de música guardada, detalles="+p);
		
	}

	@Override
	public void updatePelicula(Pelicula p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("actualizado correcto => detalle="+p);
	}

	@Override
	public List<Pelicula> listPeliculas() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Pelicula> lista = session.createQuery("from Pelicula").list();
		for(Pelicula m : lista){
			logger.info("Lista :"+m);
		}
		
		return lista;
	}

	@Override
	public Pelicula getPeliculaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Pelicula m = (Pelicula) session.load(Pelicula.class, new Integer(id));
		logger.info("Musica, detalle="+m);
		return m;
	}

	@Override
	public void removePelicula(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Pelicula m = (Pelicula) session.load(Pelicula.class, new Integer(id));
		
		if(null != m){
			session.delete(m);
		}
		logger.info("Pelicula borrada, detalle="+m);		
	}

	
	
}
