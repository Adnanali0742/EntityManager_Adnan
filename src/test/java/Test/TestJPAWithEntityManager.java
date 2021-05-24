package Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import datamodel.Question;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContextJPA.xml")
public class TestJPAWithEntityManager {
	
	@PersistenceContext
	EntityManager em;
	
	@Test
	@Transactional
	public void test() {
		Question entity = new Question("Test");
		em.persist(entity);
	}

}
