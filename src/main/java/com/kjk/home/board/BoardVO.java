package com.kjk.home.board;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardVO
{
	private Long num;
	private String writer;
	private String title;
	private String contents;
	private String hit;
	private Date regDate;
	
	private MultipartFile[] files;
	private List<BoardFileVO> boardFileVOs;
	
}
