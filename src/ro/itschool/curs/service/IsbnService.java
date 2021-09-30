package ro.itschool.curs.service;

import java.util.List;

import ro.itschool.curs.dao.IsbnDao;
import ro.itschool.curs.entity.Isbn;

public class IsbnService {

	
	private IsbnDao isbnDao;

	public IsbnService() {
		super();
		this.isbnDao = new IsbnDao();
	}

	public void saveIsbn(Isbn isbn) {
		isbnDao.openCurrentSessionwithTransaction();
		isbnDao.persist(isbn);
		isbnDao.closeCurrentSessionwithTransaction();
	}

	public void updateIsbn(Isbn isbn) {
		isbnDao.openCurrentSessionwithTransaction();
		isbnDao.update(isbn);
		isbnDao.closeCurrentSessionwithTransaction();
	}

	public Isbn findIsbnById(int id) {
		isbnDao.openCurrentSession();
		Isbn isbn = isbnDao.findById(id);
		isbnDao.closeCurrentSession();
		return isbn;
	}

	public void deleteIsbn(Isbn isbn) {
		isbnDao.openCurrentSessionwithTransaction();
		isbnDao.delete(isbn);
		isbnDao.closeCurrentSessionwithTransaction();
	}

	public List<Isbn> findAllIsbns() {
		isbnDao.openCurrentSession();
		List<Isbn> lista = isbnDao.findAll();
		isbnDao.closeCurrentSession();
		return lista;
	}

	public void deleteAllIsbns() {
		isbnDao.openCurrentSessionwithTransaction();
		isbnDao.deleteAll();
		isbnDao.closeCurrentSessionwithTransaction();
	}
}
