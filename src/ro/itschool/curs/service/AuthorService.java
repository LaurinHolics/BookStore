package ro.itschool.curs.service;

import java.util.List;

import ro.itschool.curs.dao.AuthorDao;
import ro.itschool.curs.entity.Author;

public class AuthorService {
	
	private AuthorDao authorDao;

	public AuthorService() {
		super();
		this.authorDao = new AuthorDao();
	}

	public void saveAuthor(Author author) {
		authorDao.openCurrentSessionwithTransaction();
		authorDao.persist(author);
		authorDao.closeCurrentSessionwithTransaction();
	}

	public void updateAuthor(Author author) {
		authorDao.openCurrentSessionwithTransaction();
		authorDao.update(author);
		authorDao.closeCurrentSessionwithTransaction();
	}

	public Author findAuthorById(int id) {
		authorDao.openCurrentSession();
		Author author = authorDao.findById(id);
		authorDao.closeCurrentSession();
		return author;
	}

	public void deleteAuthor(Author author) {
		authorDao.openCurrentSessionwithTransaction();
		authorDao.delete(author);
		authorDao.closeCurrentSessionwithTransaction();
	}

	public List<Author> findAllAuthors() {
		authorDao.openCurrentSession();
		List<Author> lista = authorDao.findAll();
		authorDao.closeCurrentSession();
		return lista;
	}

	public void deleteAllAuthors() {
		authorDao.openCurrentSessionwithTransaction();
		authorDao.deleteAll();
		authorDao.closeCurrentSessionwithTransaction();
	}

}
