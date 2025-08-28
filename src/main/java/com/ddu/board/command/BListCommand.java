package com.ddu.board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ddu.board.dao.BoardDao;
import com.ddu.board.dto.BoardDto;

public class BListCommand implements BCommand {
	public void execute(Model model, HttpServletRequest request) {
		BoardDao boardDao = new BoardDao();
		List<BoardDto> boardDtos = boardDao.boardList();
		model.addAttribute("boardDtos",boardDtos);
	}
}
