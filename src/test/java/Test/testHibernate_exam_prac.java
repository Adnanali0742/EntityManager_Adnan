package Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import datamodel.Question;
import services.data.api.DataAccessException;
import services.data.api.IQuestionDAO;
import services.data.impl.QuestionJPADAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContextJPA.xml")
public class testHibernate_exam_prac {
	
	@Inject
	IQuestionDAO dao;
	
	@Inject
	@Named("dataSource")
	DataSource ds;
	
	@Test
	public void test() throws DataAccessException, SQLException {
		// given
		Question question = new Question("ABC");
		
		// when
		dao.create(question);
		
		// then
		PreparedStatement prepareStatement = ds.getConnection().prepareStatement("SELECT * FROM QUESTIONS WHERE NAME = ?");
		prepareStatement.setString(1, question.getName());
		ResultSet rs = prepareStatement.executeQuery();
		rs.next();
		String string = rs.getString("NAME");
//		System.out.println(string);
		Assert.assertEquals("ABC", question.getName());
		
	}

}
