package com.ticketero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ticketero.model.TipoDeEvento;

@Repository
public class TipoDeEventoDAOImpl implements TipoDeEventoDAO {

	private static final Logger logger = LoggerFactory.getLogger(TipoDeEventoDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoDeEvento> listTipoDeEventos() {
		Session session = this.sessionFactory.getCurrentSession();
		logger.info("Buscar tipo de eventos");
		List<TipoDeEvento> TipoDeEventoList = session.createQuery("from TipoDeEvento").list();
		for(TipoDeEvento p : TipoDeEventoList){
			logger.info("Tipos de evento List:"+p);
		}
		return TipoDeEventoList;
	}
	
	@Override
	public TipoDeEvento getTipoDeEventoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		TipoDeEvento p = (TipoDeEvento) session.load(TipoDeEvento.class, new Integer(id));
		logger.info("TipoDeEvento loaded successfully, TipoDeEvento details="+p);
		return p;
	} 
	
}
