package ro.itschool.curs.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
	
	@Column
	private String name;
	
	@Column
	private int pages;
	
	@Column
	private String author;
	
	@Column
	private double price;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "isbn_id")
	private Isbn isbn;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private PublishingHouse publishingHouse;

	public Book(String name, int pages, String author, double price,Isbn isbn, PublishingHouse publishingHouse) {
		super();
		this.name = name;
		this.pages = pages;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
		this.publishingHouse = publishingHouse;
	}

}
