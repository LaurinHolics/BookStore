package ro.itschool.curs.dao;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
		session.save(entity);
	}

	@Override
	public void update(Book entity) {
		log.info("Am apelat metoda update");
		session.update(entity);

	}

	@Override
	public Book findById(Integer id) {
		log.info("Am apelat metoda find");
		return session.get(Book.class, id);

	}

	public List<Book> findBooksByName(String name) throws Exception {
		log.info("Am apelat metoda find by name");
		List<Book> books = session.createQuery("from Book b where b.name like CONCAT('%',:name,'%')")
				.setParameter("name", name).list();
		log.info("Numele dupa care cautam cartea este: " + name);
		log.info("Avem cartile: " + books);
		if (books.isEmpty())
			throw new Exception("Nu exista carti cu numele: " + name);
		return books;
	}

	public Set<Book> filterByPrice(int price) {
		log.info("Suntem in metoda filter by price");
		List<Book> books = session.createQuery("from Book").list();
		log.info("Am obtinut toate cartile posibile si urmeaza sa le filtram");
		return books.stream().filter(b -> b.getPrice() < price).collect(Collectors.toSet());
	}

	@Override
	public void delete(Book entity) {
		log.info("Am apelat metoda delete");
		session.delete(entity);

	}

	@Override
	public List<Book> findAll() {
		log.info("Am apelat metoda findAll");
		return session.createQuery("from Book").list();
	}

	@Override
	public void deleteAll() {
		log.info("Am apelat metoda deleteAll");
		session.createQuery("delete from Book").executeUpdate();

	}

	

}
