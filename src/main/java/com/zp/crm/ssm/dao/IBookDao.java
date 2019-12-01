package com.zp.crm.ssm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zp.crm.ssm.entity.Book;

@Repository
public interface IBookDao {
	List<Book> listAll();
	List<Map> listStationAll(Map endAddress);
	List<Map> getAllBusStationList();
}