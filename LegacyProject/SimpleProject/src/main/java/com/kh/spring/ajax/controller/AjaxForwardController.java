package com.kh.spring.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.board.model.service.BoardService;

@Controller
public class AjaxForwardController {
	
	@Autowired
	private BoardService service;

	@GetMapping("page")
	public String toAjax() {
		return "ajax/ajax";
	}
	
	@GetMapping("sync")
	public ModelAndView test1(ModelAndView mv) {
		
		int count = service.count();
		mv.addObject("count", count).setViewName("ajax/ajax");
		return mv;
	}
}