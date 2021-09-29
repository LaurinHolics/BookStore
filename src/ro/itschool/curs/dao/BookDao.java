package ro.itschool.curs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lombok.extern.java.Log;
import ro.itschool.curs.entity.Book;
import ro.itschool.curs.util.HibernateUtils;

@Log
public class BookDao implements EntityDao<Book, Integer>{
	
	private Session session;

	private Transaction transaction;

	public BookDao() {
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
	
	

	@Override
	public void persist(Book entity) {
		log.info("Am apelat metoda persist");
		session.saveOrUpdate(entity);
		
	}

	@Override
	public void update(Book entity) {
		log.info("Am apelat metoda update");
		session.saveOrUpdate(entity);
		
	}

	@Override
	public Book findById(Integer id) {
		log.info("Am apelat metoda findById");
		return 	session.get(Book.class, id);
		
	}

	
	@Override
	public void delete(Book entity) {
		log.info("Am apelat metoda delete");
		session.delete(entity);
	}

	@Override
	public List<Book> findAll() {
		log.info("Am apelat metoda findAll");
		return session.createQuery("from book").list();
	
	}

	@Override
	public void deleteAll() {
		log.info("Am apelat metoda deleteAll");
	  session.createQuery("delete from book").executeUpdate();
	}

	

}
