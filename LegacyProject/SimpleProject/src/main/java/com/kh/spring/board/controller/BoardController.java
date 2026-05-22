package com.kh.spring.board.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.board.model.dto.BoardDto;
import com.kh.spring.board.model.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("boards")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	/*
	 * 전체조회  == boards 				== GET      ==> 페이징 처리
	 * 상세조회  == boards/{boardNo}    == GET     
	 * 작성    == boards              == POST
	 * 
	 * SELECT == GET / INSERT == POST
	 */
//	@GetMapping("boards")
//	@GetMapping("boards/{boardNo}")
//	@PostMapping("boards")
	
	@GetMapping
	public ModelAndView findAll(ModelAndView mv,
								@RequestParam(name="page", defaultValue="1") int page) {
		
		Map<String, String> map = boardService.findAll(page);
		
		mv.addObject("map", map).setViewName("board/boards");
		return mv;
	}
	
	@GetMapping("/form")
	public String toForm() {
		return "board/form";
	}
	
	@PostMapping
	public String save(BoardDto board, MultipartFile upfile, HttpSession session) {
		// log.info("게시글 정보 : {}, 첨부파일 정보 : {}", board, upfile);
		// 첨부파일의 존재 유무
		// MultipartFile 객체의 fileName 필드값으로 확인해야함!
		
		/*
		 * 1. 권한있는 요청인가
		 * 2. 파일 존재 유무 체크 => 이름 바꾸기 작업 => 파일 업로드
		 * 3. 값의 유효성 검사   =>  
		 */
		boardService.save(board, upfile, session);
		return "redirect:boards";
	}
	
	@GetMapping("/{id}")
	public ModelAndView toDetail(@PathVariable(value="id") Long boardNo, ModelAndView mv) {
//		BoardDto board = boardService.findByBoardNo(boardNo);
		mv.addObject("board", boardService.findByBoardNo(boardNo)).setViewName("board/detail");
		
//		mv.setViewName("board/detail");
		return mv;
	}
	
	@GetMapping("/keyword")
	public ModelAndView findByKeyword(@RequestParam(value="condition") String condition,
									  @RequestParam(value="keyword") String keyword,
									  ModelAndView mv,
									  @RequestParam(value="page", defaultValue="1") int page) {
		Map<String, Object> map = boardService.findByKeyword(condition, keyword, page);
		
		mv.addObject("map", map).addObject("keyword", keyword).addObject("condition", condition).setViewName("board/boards");
		
		return mv;
	}
	
}
