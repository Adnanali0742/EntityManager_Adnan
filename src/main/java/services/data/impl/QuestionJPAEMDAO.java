package services.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import datamodel.Question;
import services.data.api.DataAccessException;
import services.data.api.IQuestionDAO;

@Transactional(value = Transactional.TxType.REQUIRED)
public class QuestionJPAEMDAO implements IQuestionDAO{
	
	@PersistenceContext
	EntityManager em;
	

	@Override
	public void create(Question question) throws DataAccessException {
		// TODO Auto-generated method stub
		em.persist(question);
	}

	@Override
	public void update(Question question) throws DataAccessException {
		// TODO Auto-generated method stub
		em.merge(question);
		
	}

	@Override
	public void delete(Question question) throws DataAccessException {
		// TODO Auto-generated method stub
		em.remove(question);
	}

	@Override
	public List<Question> search(Question question) throws DataAccessException {
		// TODO Auto-generated method stub
		TypedQuery<Question> query = em.createQuery("from Question", Question.class);
		return query.getResultList(); 
	}

}
