package com.simple.controller.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.controller.Controller;
import com.simple.dao.BookDao;
import com.simple.dao.ReviewDao;
import com.simple.util.NumberUtil;
import com.simple.vo.Book;
import com.simple.vo.Review;

public class DetailController implements Controller{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("DetailController.process(req,res)가 실행됨...");
		
		//요청파라미터 정보 조회하기
		int bookNo = NumberUtil.stringToInt(req.getParameter("bookno"));
		
		//책번호에 해당하는 책 정보 획득하기
		BookDao bookDao = new BookDao();
		Book detailBook = bookDao.getBookByNo(bookNo);
		
		//책번호에 해당하는 책의 리뷰정보 획득하기
		ReviewDao reviewDao = new ReviewDao();
		List<Review> reviews = reviewDao.getReviewsByBookNo(bookNo);
		
		//뷰페이지로 획득된 데이터를 전달하기 위해서
		//HttpServletRequest객체에 속성으로 저장
		req.setAttribute("detailBook", detailBook);
		
		//리뷰정보를 뷰페이지에 전달하기
		req.setAttribute("reviews", reviews);
		
		//내부이동할 뷰페이지 이름 반환
		return "book/detail.jsp";	//내부이동할 뷰 페이지 이름
	}
}
