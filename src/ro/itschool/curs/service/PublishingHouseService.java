package ro.itschool.curs.service;

import ro.itschool.curs.dao.PublishingHouseDao;
import ro.itschool.curs.entity.PublishingHouse;

public class PublishingHouseService {

	public PublishingHouseDao publishingHouseDao;
	
	
	public PublishingHouseService() {
		 publishingHouseDao = new PublishingHouseDao();
		 }
		

		public PublishingHouse findPublishingHouseById(int id) {
			publishingHouseDao.openCurrentSession();
			PublishingHouse publishingHouse = publishingHouseDao.findById(id);
			publishingHouseDao.closeCurrentSession();
			return publishingHouse;

		}
}
