package com.ddu.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ddu.board.dto.BoardDto;

public class BoardDao {
	private String driverName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/springdb?serverTimezone=Asia/Seoul";
	private String username = "root";
	private String password = "12345";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void write(String bname, String btitle, String bcontent) {
		String sql = "INSERT INTO boardtbl(bname, btitle, bcontent, bhit) VALUES (?,?,?,0)";
		
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public List<BoardDto> boardList() {
		String sql = "SELECT * FROM boardtbl ORDER BY bnum DESC";
		
		List<BoardDto> boardDtos = new ArrayList<BoardDto>();
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardDto boardDto = new BoardDto(rs.getInt("bnum"), rs.getString("btitle"), rs.getString("bcontent"),rs.getString("bname"), rs.getInt("bhit"), rs.getString("bdate"));
				
				boardDtos.add(boardDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}return boardDtos;
	}
	public BoardDto contentView(int bnum) {
		
		upHit(bnum);
		String sql = "SELECT * FROM boardtbl WHERE bnum=?";
		BoardDto boardDto =null;
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bnum);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				boardDto = new BoardDto();
				boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBcontent(rs.getString("bcontent"));
				boardDto.setBname(rs.getString("bname"));
				boardDto.setBhit(rs.getInt("bhit"));
				boardDto.setBnum(rs.getInt("bnum"));
				boardDto.setBdate(rs.getString("bdate"));
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}return boardDto;
	}
	public void upHit(int bnum) {
		String sql = "UPDATE boardtbl SET bhit=bhit + 1 WHERE bnum=?";
		
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bnum);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
