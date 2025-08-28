package com.ddu.board.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ddu.board.dao.BoardDao;
import com.ddu.board.dto.BoardDto;

public class BContentViewCommand implements BCommand {

	@Override
	public void execute(Model model , HttpServletRequest request) {
		// TODO Auto-generated method stub
		int bnum = Integer.parseInt( request.getParameter("bnum"));
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = boardDao.contentView(bnum);
		
		model.addAttribute("boardDto",boardDto);
	}

}
