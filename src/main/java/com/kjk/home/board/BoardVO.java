package com.kjk.home.board;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardVO
{
	private Long num;
	@NotBlank
	@Size(min = 2, max = 10)
	private String writer;
	@NotBlank
	@Size(min = 2, max = 10)
	private String title;
	@NotBlank
	@Size(min = 2, max = 400)
	private String contents;
	private String hit;
	private Date regDate;

	private MultipartFile[] files;
	private List<BoardFileVO> boardFileVOs;

}
