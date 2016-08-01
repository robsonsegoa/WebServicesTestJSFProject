package br.com.devmedia.webservices.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.devmedia.webservices.entities.Categoria;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CategoriaService {

	@PersistenceContext
	private EntityManager em;

	
	public List<Categoria> getCategorias(){
		Query qr= em.createQuery("select cate from Categoria cate");
		return qr.getResultList();

	}
}