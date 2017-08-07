package com.emaillist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emaillist.repository.EmaillistDao;
import com.emaillist.vo.EmaillistVo;
@Controller
public class EmaillistController {
	

	
	@Autowired
	private EmaillistDao dao;
	
	@RequestMapping("list")
	public String list(Model model) {
		
		List<EmaillistVo> list = dao.getList();
		System.out.println(list.toString());
		model.addAttribute("list",list);
		return "list";
		
	}
	
	@RequestMapping("add")
	public String add(EmaillistVo vo) {
		
		dao.insert(vo);
		return "redirect:/list";
	}
	
	@RequestMapping("form")
	public String form() {
		
		return "form";
	}
	
	@RequestMapping("test")
	public void test(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("last_name", "s");
		map.put("email", "jeju@naver.com");
		List<EmaillistVo> list = dao.getListByMap(map);
		
		System.out.println(list.toString());
		
	/*	EmaillistVo vo = dao.getByNo(2);
		System.out.println("getByNo()");
		System.out.println(vo.toString());*/
	
	}
	
	
	
}
