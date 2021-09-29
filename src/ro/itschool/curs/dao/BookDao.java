package ro.itschool.curs.dao;

import java.util.List;

import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ro.itschool.curs.entity.Book;
import ro.itschool.curs.util.HibernateUtils;

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
		session.saveOrUpdate(entity);
		
	}

	@Override
	public void update(Book entity) {
		session.saveOrUpdate(entity);
		
	}

	@Override
	public Book findById(Integer id) {
		return 	session.get(Book.class, id);
		
	}

	@Override
	public void deleteT(Book entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	

}
