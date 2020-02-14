package com.douzone.guestbook.dao.test;

import java.util.List;

import com.douzone.guestbook.dao.GuestBookDao;
import com.douzone.guestbook.vo.GuestBookVo;

public class GuestBookDaoTest {

	public static void main(String[] args) {
		//insertTest();
		//deleteTest();
		selectTest();
	}
	
	public static void selectTest() {
		List<GuestBookVo> list = new GuestBookDao().findAll();
		for(GuestBookVo vo : list) {
			System.out.println(vo);
		}
	} 
	
	public static void insertTest() {
		GuestBookVo vo = new GuestBookVo();
		vo.setName("한해용");
		vo.setContents("안녕하세요");
		vo.setPassword("1234");
		
		new GuestBookDao().insert(vo);
	}
	
	public static void deleteTest() {
		GuestBookVo vo = new GuestBookVo();
		vo.setNo(8L);
		
		new GuestBookDao().delete(vo);
	}
	
	public static void findTest() {

		new GuestBookDao().find(3L);
	}
}
