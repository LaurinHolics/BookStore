package ro.itschool.curs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lombok.extern.java.Log;
import ro.itschool.curs.entity.PublishingHouse;
import ro.itschool.curs.util.HibernateUtils;

@Log
public class PublishingHouseDao implements EntityDao<PublishingHouse, Integer> {

	private Session session;

	private Transaction transaction;

	public PublishingHouseDao() {
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
	public void persist(PublishingHouse publishingHouse) {
		log.info("Am apelat metoda persist");
		session.save(publishingHouse);

	}

	@Override
	public void update(PublishingHouse entity) {
		log.info("Am apelat metoda update");
		session.update(entity);
	}

	@Override
	public PublishingHouse findById(Integer id) {
		return session.get(PublishingHouse.class, id);
	}

	@Override
	public void delete(PublishingHouse entity) {
		log.info("Am apelat metoda delete");
		session.delete(entity);

	}

	@Override
	public List<PublishingHouse> findAll() {
		log.info("Am apelat metoda findAll");
		return session.createQuery("from PublishingHouse").list();
	}

	@Override
	public void deleteAll() {
		log.info("Am apelat metoda deleteAll");
		session.createQuery("delete from PublishingHouse").executeUpdate();

	}
}
