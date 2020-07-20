package com.simple.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.dto.BookDetailDto;
import com.simple.service.BookService;
import com.simple.util.NumberUtil;
import com.simple.vo.Book;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;
import kr.co.jhta.mvc.view.JSONView;

public class AjaxController {
	
	private JSONView jsonView = new JSONView();
	private BookService bookService = new BookService();
	
	@RequestMapping("/json/books.hta")
	public ModelAndView books(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		
		List<Book> books = bookService.getAllBooks();
		
		ModelAndView mav = new ModelAndView();
		mav.addAttribute("books", books);	//ModelAndView에 응답으로 제공할 데이터 담기
		mav.setView(jsonView);				//데이터를 JSON 응답으로 변환하는 View객체 담기
		
		return mav;
	}
	
	@RequestMapping("/json/book.hta")
	public ModelAndView book(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		int bookNo = NumberUtil.stringToInt(req.getParameter("bookno"));
		
		BookDetailDto dto = bookService.getBookDetailInfo(bookNo);
		
		ModelAndView mav = new ModelAndView();
		mav.addAttribute("dto", dto);
		mav.setView(jsonView);
		return mav;
	}
}
