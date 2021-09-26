package ro.itschool.curs.service;

import ro.itschool.curs.dao.BookDao;
import ro.itschool.curs.entity.Book;

public class BookService {

	private BookDao bookDao;

	public BookService() {
		super();
		this.bookDao = new BookDao();
	}

	public void saveBook(Book book) {
		bookDao.openCurrentSessionwithTransaction();
		bookDao.persist(book);
		bookDao.closeCurrentSessionwithTransaction();
	}
	
}
