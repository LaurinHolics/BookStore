package ro.itschool.curs.service;

import java.util.ArrayList;
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

	public List<Book> findBookByName(String name) {
		bookDao.openCurrentSession();
		List<Book> books = new ArrayList<Book>();
		try {
			books = bookDao.findBooksByName(name);
		} catch (Exception e) {
			System.out.println("AICI GESTIONAM EROAREA");
			e.printStackTrace();
		} finally {
			System.out.println("Suntem in finally");
		}
		bookDao.closeCurrentSession();
		return books;
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
