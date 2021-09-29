package ro.itschool.curs.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Book")
@Data
@NoArgsConstructor
@ToString

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
	private Isbn isbn;

	public Book(String name, int pages, String author, double price,Isbn isbn) {
		super();
		this.name = name;
		this.pages = pages;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
	}

}
