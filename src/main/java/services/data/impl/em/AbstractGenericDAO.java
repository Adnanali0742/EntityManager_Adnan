package services.data.impl.em;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import datamodel.Question;
import services.data.api.DataAccessException;
import services.data.api.IDAO;

abstract class AbstractGenericDAO<T> implements IDAO<T>{
	
	@PersistenceContext
	EntityManager em;
	

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void create(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		em.persist(entity);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void update(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		em.merge(entity);
		
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void delete(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		em.remove(entity);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public abstract List<T> search(T entity) throws DataAccessException;

}
