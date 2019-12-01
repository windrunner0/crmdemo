package com.zp.crm.ssm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.crm.ssm.dao.IBookDao;
import com.zp.crm.ssm.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	// 使用 dao 中的接口
	@Autowired
	private IBookDao bookDao;

	public List<Book> listAll(){
		return bookDao.listAll();
	}
	
	public List<Map> listStationAll(){
		return bookDao.listStationAll();
	}
}