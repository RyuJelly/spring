package kosta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.service.HelloService;

@Controller
public class HelloController {
	@Autowired
	private HelloService service;
	
	@RequestMapping("/hello")
	public ModelAndView hello(){
		// 1.비지니스 로직 호출 => Service호출
		// 2. 해당 데이터를 저장
		// 3. 뷰를 결정
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", service.getMessage());
		mav.setViewName("hello");
		
		return mav;
	}
}
