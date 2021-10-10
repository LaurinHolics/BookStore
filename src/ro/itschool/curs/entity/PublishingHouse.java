package ro.itschool.curs.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PublishingHouse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column
	private String name;

	@Column
	private String email;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "publishingHouse")
	private List<Book> books;

	public PublishingHouse(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "\n PublishingHouse [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
