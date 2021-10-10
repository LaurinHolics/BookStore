package ro.itschool.curs.service;

import java.util.List;

import ro.itschool.curs.dao.PublishingHouseDao;
import ro.itschool.curs.entity.PublishingHouse;

public class PublishingHouseService {

private PublishingHouseDao publishingHouseDao;
	
	public PublishingHouseService() {
	 publishingHouseDao = new PublishingHouseDao();
	 }
	

	public PublishingHouse findPublishingHouseById(int id) {
		publishingHouseDao.openCurrentSession();
		PublishingHouse publishingHouse = publishingHouseDao.findById(id);
		publishingHouseDao.closeCurrentSession();
		return publishingHouse;

	}
	
	public void savePublishingHouse(PublishingHouse PH) {
		publishingHouseDao.openCurrentSessionwithTransaction();
		publishingHouseDao.persist(PH);
		publishingHouseDao.closeCurrentSessionwithTransaction();
	}
	
	public void updatePublishingHouse(PublishingHouse PH) {
		publishingHouseDao.openCurrentSessionwithTransaction();
		publishingHouseDao.update(PH);
		publishingHouseDao.closeCurrentSessionwithTransaction();
	}
	public void deletePublishingHouse(PublishingHouse PH) {
		publishingHouseDao.openCurrentSessionwithTransaction();
		publishingHouseDao.delete(PH);
		publishingHouseDao.closeCurrentSessionwithTransaction();
	}
	public List<PublishingHouse> findAllPublishingHouses() {
		publishingHouseDao.openCurrentSession();
		List<PublishingHouse> lista = publishingHouseDao.findAll();
		publishingHouseDao.closeCurrentSession();
		return lista;
	}
	public void deleteAllPublishingHouses() {
		publishingHouseDao.openCurrentSessionwithTransaction();
		publishingHouseDao.deleteAll();
		publishingHouseDao.closeCurrentSessionwithTransaction();
	}
}
