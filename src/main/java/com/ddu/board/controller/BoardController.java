package com.ddu.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddu.board.command.BCommand;
import com.ddu.board.command.BContentViewCommand;
import com.ddu.board.command.BListCommand;
import com.ddu.board.command.BWriteCommand;

@Controller
public class BoardController {
	
	BCommand command = null;
	
	@RequestMapping(value = "/write_form") // 글쓰기 양식을 출력하는 요청 처피
	public String write_form() {
		return "writeForm";
	}
	@RequestMapping(value = "/write") // 유저가 작성한 글을 DB에 삽입하는 요청 처리
	public String write(HttpServletRequest request, Model model) {
		
		command = new BWriteCommand();
		command.execute(model, request);
		
		return "redirect:boardList";
	}
	@RequestMapping(value = "/boardList") // 글쓰기 양식을 출력하는 요청 처피
	public String boardList(HttpServletRequest request, Model model) {
		
		command = new BListCommand();
		command.execute(model, request);
		
		return "boardList";
	}
	@RequestMapping(value = "/content_view") // 글쓰기 양식을 출력하는 요청 처피
	public String content_view(HttpServletRequest request, Model model) {
		
		command = new BContentViewCommand();
		command.execute(model, request);
		
		return "contentView";
	}
}
