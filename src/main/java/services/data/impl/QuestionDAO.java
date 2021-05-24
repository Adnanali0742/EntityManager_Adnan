package services.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import datamodel.Question;
import services.data.api.DataAccessException;
import services.data.api.IQuestionDAO;

public class QuestionDAO implements IQuestionDAO {

	@Inject
	DataSource datasource;

	public void create(Question question) throws DataAccessException {
		try {
			Connection connection = this.datasource.getConnection();
		} catch (SQLException e) {
			throw DataAccessException.init(e);
		}

	}

	public void delete(Question question) throws DataAccessException {

		try {
			Connection connection = this.datasource.getConnection();
		} catch (SQLException e) {
			throw DataAccessException.init(e);
		}

	}

	public void update(Question question) throws DataAccessException {
		try {
			Connection connection = this.datasource.getConnection();
		} catch (SQLException e) {
			throw DataAccessException.init(e);
		}

	}

	public List<Question> search(Question questionQBE) throws DataAccessException {
		List<Question> list = new ArrayList<>();

		try {
			Connection connection = this.datasource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM questions");
			ResultSet results = preparedStatement.executeQuery();

			while (results.next()) {
				String question = results.getString("question");
				Integer id = results.getInt("id");
				Integer difficulty = results.getInt("difficulty");

				Question questionInstance = new Question(question);
				questionInstance.setDifficulty(difficulty);
				questionInstance.setId(id);
				list.add(questionInstance);
			}
		} catch (SQLException e) {
			throw DataAccessException.init(e);
		}
		return list;

	}

}
