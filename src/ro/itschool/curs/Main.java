package ro.itschool.curs;

import java.util.HashSet;
import java.util.Set;

import ro.itschool.curs.entity.Author;
import ro.itschool.curs.entity.Book;
import ro.itschool.curs.entity.Isbn;
import ro.itschool.curs.entity.PublishingHouse;
import ro.itschool.curs.service.BookService;

public class Main {

	public static void main(String[] args) {

		
		BookService bookService = new BookService();
		PublishingHouse house = new PublishingHouse("house5", "house5@mail.com");
		Isbn isbn = new Isbn("123456789asdfg");
		
		
		Set<Author> authors = new HashSet<>();
		Author author1 = new Author("name1","vorname1");
		Author author2 = new Author("name1","vorname1");
		
		authors.add(author1);
		authors.add(author2);
		
		
		Book book = new Book("name", 150, authors, 15.99, isbn, house);
		bookService.saveBook(book);

	}
}