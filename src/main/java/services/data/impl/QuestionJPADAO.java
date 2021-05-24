package services.data.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datamodel.Question;
import services.data.api.IQuestionDAO;

public class QuestionJPADAO implements IQuestionDAO{
	@Inject
	SessionFactory sf;
	
	public void create(Question question) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(question);
		tx.commit();
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
