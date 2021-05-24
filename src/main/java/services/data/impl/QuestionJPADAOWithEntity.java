package services.data.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.test.context.jdbc.SqlConfig.TransactionMode;

import datamodel.Question;

@Transactional(value = Transactional.TxType.REQUIRED)
public class QuestionJPADAOWithEntity {
	@Inject
	SessionFactory sf;
	
	public void create(Question question) {
		Session session = sf.openSession();

		session.save(question);
	}
	
	public void update(Question question) {
		sf.openSession().save(question);
	}
	
	public void delete(Question question) {
		sf.openSession().save(question);
	}
	
	public List<Question> search(Question question){
		Query<Question> query = sf.openSession().createQuery("from Question");
		List<Question> list = query.list();
		System.out.println(list);
		return list;
	}

}
