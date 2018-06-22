package com.ticketero.dao;

import java.util.List;

import com.ticketero.model.Teatro;

public interface TeatroDAO {

	public void addTeatro(Teatro p);
	public void updateTeatro(Teatro p);
	public List<Teatro> listTeatros();
	public Teatro getTeatroById(int id);
	public void removeTeatro(int id);
}
