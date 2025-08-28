package com.ddu.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
	private int bnum;
	private String btitle;
	private String bcontent;
	private String bname;
	private int bhit;
	private String bdate;
}
