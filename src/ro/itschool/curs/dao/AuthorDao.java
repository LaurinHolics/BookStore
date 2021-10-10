package ro.itschool.curs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lombok.extern.java.Log;
import ro.itschool.curs.entity.Author;
import ro.itschool.curs.util.HibernateUtils;

@Log
public class AuthorDao {
	
	private Session session;

	private Transaction transaction;

	public AuthorDao() {
	}

	public Session openCurrentSession() {
		session = HibernateUtils.getSessionFactory().openSession();
		return session;
	}

	public Session openCurrentSessionwithTransaction() {
		session = HibernateUtils.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		return session;
	}

	public void closeCurrentSession() {
		session.close();
	}

	public void closeCurrentSessionwithTransaction() {
		transaction.commit();
		session.close();
	}

//	@Override
	public void persist(Author entity) {
		log.info("Am apelat metoda persist din AuthorDao");
		session.save(entity);
	}

//	@Override
	public void update(Author entity) {
		log.info("Am apelat metoda update din AuthorDao");
		session.update(entity);
	}

//    @Override
	public Author findById(Integer id) {
		log.info("Am apelat metoda find din AuthorDao");
		return session.get(Author.class, id);
	}

//	@Override
	public void delete(Author entity) {
		log.info("Am apelat metoda delete din AuthorDao");
		session.delete(entity);
	}

//	@Override
	@SuppressWarnings("unchecked")
	public List<Author> findAll() {
		log.info("Am apelat metoda findAll din AuthorDao");
		return session.createQuery("from Author").list();
	}

//	@Override
	public void deleteAll() {
		log.info("Am apelat metoda deleteAll din AuthorDao");
		session.createQuery("delete from Author").executeUpdate();
	}

}
