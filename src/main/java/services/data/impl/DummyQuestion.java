package services.data.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import datamodel.Question;
import services.data.api.DataAccessException;
import services.data.api.IQuestionDAO;

public class DummyQuestion implements IQuestionDAO{
	List<Question> dummyQuestionDataSource = new ArrayList<>();

	@Override
	public void create(Question question) throws DataAccessException {
		dummyQuestionDataSource.add(question);
		
	}

	@Override
	public void update(Question question) throws DataAccessException {

		
	}

	@Override
	public void delete(Question question) throws DataAccessException {

		
	}

	@Override
	public List<Question> search(Question question) throws DataAccessException {
		return dummyQuestionDataSource.stream()
				.filter(q -> q.getName().equals(question.getName()))
				.collect(Collectors.toList());
	}

}
