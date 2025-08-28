package com.ddu.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddu.board.dao.BoardDao;

@Controller
public class BoardController {
	@RequestMapping(value = "/write_form") // 글쓰기 양식을 출력하는 요청 처피
	public String write_form() {
		return "writeForm";
	}
	@RequestMapping(value = "/write") // 유저가 작성한 글을 DB에 삽입하는 요청 처리
	public String write(HttpServletRequest request, Model model) {
		BoardDao boardDao = new BoardDao();
		boardDao.write(request.getParameter("bname"), request.getParameter("btitle"),request.getParameter("bcontent"));
		
		
		return "redirect:boardList";
	}
}
