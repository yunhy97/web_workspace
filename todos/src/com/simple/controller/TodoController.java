package com.simple.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simple.dto.TodoDto;
import com.simple.service.TodoService;
import com.simple.util.NumberUtil;
import com.simple.util.StringUtil;
import com.simple.vo.User;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;
import kr.co.jhta.mvc.view.JSONView;
import kr.co.jhta.util.pagination.Pagination;

@Controller
public class TodoController {

	private JSONView jsonView = new JSONView();
	private TodoService todoService = new TodoService();
	
	@RequestMapping("/todo/detail.hta")
	public ModelAndView detail(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int todoNo = NumberUtil.stringToInt(req.getParameter("todono"));
		
		TodoDto todoDto = todoService.getTodoDetail(todoNo);
		
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("loginUser");
		
		if(user !=null && user.getId().equals(todoDto.getUserId())) {
			todoDto.setCanModify(true);
		}
		
		ModelAndView mav = new ModelAndView();
		
		mav.addAttribute("detail", todoDto);
		mav.setView(jsonView);
		return mav;
	}
	
	@RequestMapping("/todo/updatestatus.hta")
	public ModelAndView update(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int todoNo = NumberUtil.stringToInt(req.getParameter("todono"));
		String status = req.getParameter("status");
		TodoDto todoDto = todoService.updateTodoStatus(todoNo, status);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addAttribute("update", todoDto);
		mav.setView(jsonView);
		return mav;
	}
	
	@RequestMapping("/todo/list.hta")
	public ModelAndView list(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/todos.jsp");
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("loginUser");
		
		int pageNo = NumberUtil.stringToInt(req.getParameter("pageNo"),1);
		int rows = NumberUtil.stringToInt(req.getParameter("rows"),	5);
		String status = StringUtil.nullToValue(req.getParameter("status"), "전체");
		String keyword = StringUtil.nullToBlank(req.getParameter("keyword"));
		
		Map<String, Object> map = todoService.getTodoList(user.getId(), pageNo, rows, status, keyword);
		Pagination pagination = (Pagination)map.get("pagination");
		List<TodoDto> todos = (List<TodoDto>)map.get("todos");
		
		mav.addAttribute("todos", todos);
		mav.addAttribute("pagination", pagination);
		return mav;
	}
}
