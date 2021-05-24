package Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.inject.Inject;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import datamodel.Choice;
import datamodel.Question;
import services.data.api.DataAccessException;
import services.data.api.IChoice;
import services.data.api.IQuestionDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContextJPA.xml")
public class TestEntity {
	
	private static final Logger LOGGER = LogManager.getLogger(TestEntity.class);
	
	@Inject
	IQuestionDAO questionDao;
	
	@Inject
	IChoice choiceDao;
	
	@Inject
	DataSource ds;
	
	@Test 
	@Transactional
	public void test() throws Exception {
		Prepareable();
		PreparedStatement preparedStatement = ds.getConnection()
				.prepareStatement("SELECT ID FROM CHOICES");
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			System.out.println("test");
			System.out.println(rs.getInt(1));
		}
	}

	private void Prepareable() {
		try {
			Question question = new Question("test");
			questionDao.create(question);
			Choice choice = new Choice();
			choice.setLabel("test label");
			choice.setQuestion(question);
			choiceDao.create(choice);
			LOGGER.info("try to record");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
	}
	

}
