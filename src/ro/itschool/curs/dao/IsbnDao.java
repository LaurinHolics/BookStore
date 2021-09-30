package ro.itschool.curs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lombok.extern.java.Log;
import ro.itschool.curs.entity.Isbn;
import ro.itschool.curs.util.HibernateUtils;

@Log
public class IsbnDao implements EntityDao<Isbn, Integer>{

	private Session session;

	private Transaction transaction;

	public IsbnDao() {
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
	public void persist(Isbn entity) {
		log.info("Am apelat metoda persist");
		session.save(entity);
	}

	@Override
	public void update(Isbn entity) {
		log.info("Am apelat metoda update");
		session.update(entity);

	}

	@Override
	public Isbn findById(Integer id) {
		log.info("Am apelat metoda find");
		return session.get(Isbn.class, id);

	}

	@Override
	public void delete(Isbn entity) {
		log.info("Am apelat metoda delete");
		session.delete(entity);

	}

	@Override
	public List<Isbn> findAll() {
		log.info("Am apelat metoda findAll");
		return session.createQuery("from Isbn").list();
	}

	@Override
	public void deleteAll() {
		log.info("Am apelat metoda deleteAll");
		session.createQuery("delete from Isbn").executeUpdate();

	}


}
