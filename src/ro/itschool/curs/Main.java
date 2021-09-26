package ro.itschool.curs;

import ro.itschool.curs.dao.BookDao;
import ro.itschool.curs.entity.Book;

public class Main {

	public static void main(String[] args) {
		
		BookDao bookDao = new BookDao();
		
		Book book = new Book(1, "name100", 100,"author100", 22.2);
		
		bookDao.openCurrentSessionwithTransaction();
		bookDao.persist(book);		
		bookDao.closeCurrentSessionwithTransaction();
		
	}

}
