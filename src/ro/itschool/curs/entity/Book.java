package ro.itschool.curs.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
	
	private int id;
	private String name;
	private int pages;
	private String author;
	private double price;

}
