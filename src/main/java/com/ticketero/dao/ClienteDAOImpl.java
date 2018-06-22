package com.ticketero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ticketero.model.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ClienteDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addCliente(Cliente p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Cliente saved successfully, Cliente Details="+p);
	}

	@Override
	public void updateCliente(Cliente p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Cliente updated successfully, Cliente Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listClientes() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Cliente> ClientesList = session.createQuery("from Cliente").list();
		for(Cliente p : ClientesList){
			logger.info("Cliente List::"+p);
		}
		return ClientesList;
	}

	@Override
	public Cliente getClienteById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Cliente p = (Cliente) session.load(Cliente.class, new Integer(id));
		logger.info("Cliente loaded successfully, Cliente details="+p);
		return p;
	}

	@Override
	public void removeCliente(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cliente p = (Cliente) session.load(Cliente.class, new Integer(id));
		
		if(null != p){
			session.delete(p);
		}
		logger.info("Cliente deleted successfully, Cliente details="+p);
	}

}
