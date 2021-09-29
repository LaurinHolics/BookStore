package ro.itschool.curs;

import ro.itschool.curs.entity.Book;
import ro.itschool.curs.entity.PublishingHouse;
import ro.itschool.curs.service.BookService;

public class Main {

	public static void main(String[] args) {
		
		BookService bookService = new BookService();
		PublishingHouse house = new PublishingHouse("house5","house5@mail.com");
		Book book = new Book(1, "name111" , 100,"author100", 22.2,house);
		bookService.saveBook(book);
//		book.setAuthor("Timi");
//		bookService.updateBook(book);
//		System.out.println(bookService.findBookById(3));
//		bookService.deleteBook(book);
//		System.out.println(bookService.findAllBooks());
//		bookService.deleteAllBooks();
	}

}
