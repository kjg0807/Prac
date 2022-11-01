package com.kjk.home.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kjk.home.util.Pager;

@Mapper
public interface BoardMapper
{
	public List<BoardVO> getList(Pager pager) throws Exception;
}
