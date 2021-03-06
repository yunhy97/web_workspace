package com.simple.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simple.service.TodoService;
import com.simple.service.UserService;
import com.simple.util.NumberUtil;
import com.simple.vo.Todo;
import com.simple.vo.User;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;
import kr.co.jhta.mvc.view.JSONView;

@Controller
public class TodoController {

	private TodoService todoService = new TodoService();
	private UserService userService = new UserService();
	private JSONView jsonView = new JSONView();
	
	/*
	 * 신규회원 가입
	 * 요청방식 : POST
	 * 요청파라미터 : id, name, password, email
	 * 응답 : 
	 * 		{status:"success", username:"홍길동"}
	 * 		{status:"fail", message:"동일한 아이디가 이미 사용중입니다."}
	 */
	@RequestMapping("/register.hta")
	public ModelAndView registerUser(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();

		
		//요청처리
		try {
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String password = req.getParameter("pwd");
			String email = req.getParameter("email");
			
			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setPassword(password);
			user.setEmail(email);
			
			userService.addNewUser(user);
			
			dataMap.put("status", "success");
			dataMap.put("username", user.getId());
			
		} catch(Exception e) {
			e.printStackTrace();
			dataMap.put("status", "fail");
			dataMap.put("message", "동일한 아이디가 이미 사용중입니다.");
		}
		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		return mav;
	}
	/*
	 * 요청방식 : POST
	 * 요청파라미터 : id, password
	 * 응답
	 * 		{status:"success", username:"홍길동"}
	 * 		{status:"fail", message:"아이디 혹은 비밀번호가 올바르지 않습니다."}
	 */
	@RequestMapping("/login.hta")
	public ModelAndView loginUser(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();

		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		//요청처리
		try {
			String userId = req.getParameter("userid");
			String userPwd = req.getParameter("userpwd");
			
			User user = userService.getLoginUser(userId, userPwd);
			
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", user);
			
			dataMap.put("status", "success");
			dataMap.put("username", user.getName());
			
		} catch(Exception e) {
			e.printStackTrace();
			dataMap.put("status", "fail");
			dataMap.put("message", "아이디 혹은 비밀번호가 올바르지 않습니다.");
		}
		return mav;
	}
	/*
	 * 요청방식 : GET
	 * 요청파라미터 : 없음
	 * 응답
	 * 		{status:"success"}
	 */
	@RequestMapping("/logout.hta")
	public ModelAndView logoutUser(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();

		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		//요청처리
		HttpSession session = req.getSession();
		if(session != null) {			
			session.invalidate();
		}
			
		dataMap.put("status", "success");
			
		
		return mav;
	}
	/*
	 * 요청방식 : GET
	 * 요청파라미터 : 없음
	 * 응답
	 * 		{status:"success", todos:[{no:1,title:"장보기"....},{},{}]}
	 */
	@RequestMapping("/mytodos.hta")
	public ModelAndView myTodo(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginUser");
		if (user == null) {
			dataMap.put("status", "fail");
		} else {
			
			List<Todo> todos = todoService.getMyTodos(user.getId());
			
			dataMap.put("status", "success");
			dataMap.put("todos", todos);
		}
		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		//요청처리
			
		 
		return mav;
	}
	/*
	 * 요청방식 : GET
	 * 요청파라미터 : todoNo
	 * 응답
	 * 		{status:"success", todo:{no:1, title:"장보기", ...}}
	 */
	@RequestMapping("/todo.hta")
	public ModelAndView todoDetail(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = req.getSession();
		
		User user = (User) session.getAttribute("loginUser");
		if (user == null) {
			dataMap.put("status", "fail");
		} else {
			
			//요청처리
			int todoNo = NumberUtil.stringToInt(req.getParameter("todoNo"));
			Todo todo = todoService.getTodoDetail(todoNo);
			dataMap.put("todos", todo);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		return mav;
	}
	/*
	 * 요청방식 : POST
	 * 요청파라미터 : title, content, day
	 * 응답
	 * 		{status:"success", todo:{no:1, title:"장보기", ...}}
	 */
	@RequestMapping("/addtodo.hta")
	public ModelAndView registerTodo(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginUser");
		if (user == null) {
			dataMap.put("status", "fail");
		} else {
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			Date day = new SimpleDateFormat().parse(req.getParameter("day"));
			
			Todo todo = new Todo();
			
			todo.setTitle(title);
			todo.setContent(content);
			todo.setDay(day);
			todo.setUserId(user.getId());
			
			todo = todoService.addNewTodo(todo);
			
			dataMap.put("status", "success");
			dataMap.put("todo", todo);
		}
		
		
		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		//요청처리
		
		return mav;
	}
	/*
	 * 요청방식 : POST
	 * 요청파라미터 : no, title, content, day, status
	 * 응답
	 * 		{status:"success", todo:{no:1, title:"장보기", ...}}
	 */
	@RequestMapping("/modifytodo.hta")
	public ModelAndView modifyTodo(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		int no = NumberUtil.stringToInt(req.getParameter("todono"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Date day = new SimpleDateFormat().parse(req.getParameter("day"));
		String status = req.getParameter("status");
		
		Todo todo = new Todo();
		todo.setNo(no);
		todo.setTitle(title);
		todo.setContent(content);
		todo.setDay(day);
		todo.setStatus(status);
		
		
		Todo todoo = todoService.updateTodo(todo);
		
		dataMap.put("status", "success");
		dataMap.put("todos", todoo);
		
		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		//요청처리
		
		return mav;
	}
}
