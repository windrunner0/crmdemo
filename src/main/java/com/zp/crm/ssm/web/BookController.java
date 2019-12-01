package com.zp.crm.ssm.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zp.crm.ssm.entity.Book;
import com.zp.crm.ssm.service.BookServiceImpl;

@Controller
public class BookController {
	
	private static final Logger logger = org.apache.log4j.Logger
			.getLogger(BookController.class);
	
	@Autowired
	private BookServiceImpl bookService;

	// 请求url
	@RequestMapping(value = "/books")
	public ModelAndView getList() {
		System.out.println("===================================进入服务=======================");
		// 页面的名字
		ModelAndView mv = new ModelAndView("list");
		// 获取数据
		List<Book> list = bookService.listAll();
		mv.addObject("book", list);
		return mv;
	}
	
	// 请求url
		@RequestMapping(value = "/JsonBooks")
		@ResponseBody
		public List<Map<String, Object>> getJsonList() {
			System.out.println("========进入服务===============");
			List l = new ArrayList();
			List<Book> list = bookService.listAll();
			for (int i = 0; i < list.size(); i++) {
				Book r = list.get(i);
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("bookid", r.getBookid());
				m.put("bookname", r.getbookname());
				l.add(m);
			}
			logger.info("=====输出内容为======" + l);
			return l;
		}
		
//		@RequestParam(value = "loginName", required = true) String loginName,
		// 请求url
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value = "/getBusStationList" )
		@ResponseBody
		public Map getBusStationList(String startaddress,String endAddress,String totalman,String time) throws Exception {
			logger.info("===进入服务getBusStationList request: startaddress=" + startaddress
					+ ",endAddress=" + endAddress + ",totalman="+totalman + ",time=" + time + "============");
			Map m = new HashMap();
			if(totalman != null && Integer.parseInt(totalman) > 10){
				m.put("code", "ZP0001");
				m.put("msg", "人数太多，暂无车辆");
				m.put("type", "E");
				return m;
//				throw new Exception("人数太多，暂无车辆");
			}
			if(Integer.parseInt(totalman) > 10){
				m.put("code", "ZP0001");
				m.put("msg", "人数太多，暂无车辆");
				m.put("type", "E");
				return m;
//				throw new Exception("人数太多，暂无车辆");
			}
			
			m.put("code", "000000");
			m.put("msg", "交易成功");
			m.put("type", "S");
			List<Map> list = bookService.listStationAll();
			logger.info("=====服务getBusStationList response:" + list + "============");
			m.put("List", list);
			return m;
		}

}