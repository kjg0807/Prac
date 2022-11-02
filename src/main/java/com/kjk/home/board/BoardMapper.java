package com.kjk.home.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kjk.home.util.Pager;

@Mapper
public interface BoardMapper
{
	public List<BoardVO> getList(Pager pager) throws Exception;

	public Long Count(Pager pager) throws Exception;

	public int setWriteList(BoardVO boardVO) throws Exception;

	public int setFileWrite(BoardFileVO boardFileVO) throws Exception;

	public BoardVO getDetail(BoardVO boardVO) throws Exception;

	public BoardFileVO getDetailFileDown(BoardFileVO boardFileVO) throws Exception;
}
