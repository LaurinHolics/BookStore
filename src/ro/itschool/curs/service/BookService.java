package ro.itschool.curs.service;

import java.util.List;

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
	
	public void updateBook(Book book) {
		bookDao.openCurrentSessionwithTransaction();
		bookDao.update(book);
		bookDao.closeCurrentSessionwithTransaction();
	}
	
	public Book findBookById(int id) {
		bookDao.openCurrentSession();
		Book book = bookDao.findById(id);
		bookDao.closeCurrentSession();
		return book;
	}


	public void deleteBook(Book book) {
		bookDao.openCurrentSessionwithTransaction();
		bookDao.delete(book);
		bookDao.closeCurrentSessionwithTransaction();
	}

	public List<Book> findAllBooks() {
		bookDao.openCurrentSession();
		List<Book> lista = bookDao.findAll();
		bookDao.closeCurrentSession();
		return lista;
	}

	public void deleteAllBooks() {
		bookDao.openCurrentSessionwithTransaction();
		bookDao.deleteAll();
		bookDao.closeCurrentSessionwithTransaction();
	}
}
