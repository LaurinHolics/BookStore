package ro.itschool.curs;

import ro.itschool.curs.dao.BookDao;
import ro.itschool.curs.entity.Book;
import ro.itschool.curs.service.BookService;

public class Main {

	public static void main(String[] args) {
		
		BookService bookService = new BookService();
		Book book = new Book(1, "name111" , 100,"author100", 22.2);
		bookService.saveBook(book);
		book.setAuthor("Timi");
		bookService.updateBook(book);
		System.out.println(bookService.findBookById(3));
//		bookService.deleteBook(book);
		System.out.println(bookService.findAllBooks());
//		bookService.deleteAllBooks();
	}

}
