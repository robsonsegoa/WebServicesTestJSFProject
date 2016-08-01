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

import br.com.devmedia.webservices.entities.Produto;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ProdutoService {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Produto> getProdutoByDescricao(String desc){
		Query qr= em.createQuery("select prod from Produto prod where prod.descricao like  ?1");
		qr.setParameter(1,"%"+desc+"%");
		return qr.getResultList();

	}
	
	public List<Produto> getProdutoByNome(String nome){
		Query qr= em.createQuery("select prod from Produto prod where prod.descricao like  ?1");
		qr.setParameter(1,"%"+nome+"%");
		return qr.getResultList();

	}

	
	
	
}
