package services.data.impl.em;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import datamodel.Choice;
import datamodel.Question;
import services.data.api.DataAccessException;
import services.data.api.IChoice;

public class ChoiceJPAEMDAO extends AbstractGenericDAO<Choice> implements IChoice{

	@Override
	public List<Choice> search(Choice choice) throws DataAccessException {
		TypedQuery<Choice> query = em.createQuery("from Choice", Choice.class);
		return query.getResultList(); 

	}

}
