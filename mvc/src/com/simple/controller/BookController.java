package com.simple.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.dto.BookDetailDto;
import com.simple.service.BookService;
import com.simple.util.NumberUtil;
import com.simple.vo.Book;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;

@Controller
public class BookController {

	private BookService bookService = new BookService();
	
	@RequestMapping("/book/list.hta")
	public ModelAndView list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		List<Book> books = bookService.getAllBooks();
		
		mav.setViewName("book/list.jsp");	//뷰페이지 이름
		mav.addAttribute("books", books);	//뷰페이지에 전달할 데이터
		
		return mav;
	}
	
	@RequestMapping("/book/detail.hta")
	public ModelAndView detail(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int bookNo = NumberUtil.stringToInt(req.getParameter("bookno"));
		
		BookDetailDto dto = bookService.getBookDetailInfo(bookNo);
		
		mav.setViewName("/book/detail.jsp");
		mav.addAttribute("book", dto.getBook());
		mav.addAttribute("reviews", dto.getReviews());
		
		return mav;
	}
}
