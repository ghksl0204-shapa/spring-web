package com.kh.spring.ajax.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring.board.model.service.BoardService;

@Controller
public class AjaxController {

	@Autowired
	private BoardService service;
	
	@ResponseBody 
	@GetMapping(value="async", produces="application/json; chatset=UTF-8")
	public Map<String, Object> ajaxReturn() {
		return Map.of("result", service.count());
	}
	
}