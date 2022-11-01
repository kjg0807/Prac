package com.kjk.home.board;

import java.sql.Date;

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
}
