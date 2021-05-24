package services.data.api;

import java.util.List;

import datamodel.Question;

public interface IQuestionDAO {
	
	public void create(Question question) throws DataAccessException;
	public void update(Question question) throws DataAccessException;
	public void delete(Question question) throws DataAccessException;
	public List<Question> search(Question question) throws DataAccessException;
	

}
