package ro.itschool.curs.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Hibernate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.itschool.curs.enums.BookFormat;
import ro.itschool.curs.enums.BookGenre;

@Entity
@Table(name = "Book")
@Getter
@Setter
@NoArgsConstructor
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column(nullable = false)
	private String name;

	@Column
	private int pages;

	@Enumerated(EnumType.STRING)
	@Column(name = "book_format")
	private BookFormat bookFormat;

	@Column(nullable = false)
	private BookGenre bookGenre;

	@Column
	private double price;

	@Column
	private int stock;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "discount_id")
	private Discount discount;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "isbn_id")
	private Isbn isbn;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private PublishingHouse publishingHouse;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "author_book", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "author_id") })
	private Set<Author> author = new HashSet<>();

	public Book(String name, BookGenre bookGenre, int pages, Set<Author> author, double price, BookFormat bookFormat,
			Isbn isbn, PublishingHouse publishingHouse, int stock, Discount discount) {
		super();
		this.name = name;
		this.bookGenre = bookGenre;
		this.pages = pages;
		this.author = author;
		this.price = price;
		this.bookFormat = bookFormat;
		this.isbn = isbn;
		this.publishingHouse = publishingHouse;
		this.stock = stock;
		this.discount = discount;
	}

	@Override

	public String toString() {
		String finalString;
		finalString = "Book: id=" + id + ", name=" + name + ", pages=" + pages + ", bookFormat=" + bookFormat
				+ ", bookGenre=" + bookGenre + ", price=" + price + ", stock=" + stock + "\n";

		if (Hibernate.isInitialized(this.author) && this.author != null)
			finalString += this.author.toString();

		if (Hibernate.isInitialized(this.publishingHouse) && this.publishingHouse != null)
			finalString += this.publishingHouse.toString();

		if (Hibernate.isInitialized(this.discount) && this.discount != null)
			finalString += this.discount.toString();

		if (Hibernate.isInitialized(this.isbn) && this.isbn != null)
			finalString += this.isbn.toString();

		return finalString;
	}

}
