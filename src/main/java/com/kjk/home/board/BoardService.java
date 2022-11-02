package com.kjk.home.board;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kjk.home.util.FileManager;
import com.kjk.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService
{
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private FileManager fileManager;

	@Value("${app.upload.qna}")
	private String path;

	public List<BoardVO> getList(Pager pager) throws Exception
	{
		// pager.makeRow();
		Long totalCount = boardMapper.Count(pager);
		pager.getNum(totalCount);
		pager.getRowNum();

		return boardMapper.getList(pager);
	}

	public int setWriteList(BoardVO boardVO) throws Exception
	{
		int rs = boardMapper.setWriteList(boardVO);
		log.info("===== write rs: {} =====", rs);
		// if (rs < 1)
		// {
		// throw new Exception();
		// }

		// log.info("RealPath: {}", path);
		File file = new File(path);
		// exists - 존재하는지
		if (!file.exists())
		{
			boolean ch = file.mkdirs();
		}

		for (MultipartFile f : boardVO.getFiles())
		{
			if (!f.isEmpty())
			{
				log.info("Filename: {}", f.getOriginalFilename());
				String fileName = fileManager.saveFile(f, path);
				BoardFileVO boardFileVO = new BoardFileVO();
				boardFileVO.setFileName(fileName);
				boardFileVO.setOriName(f.getOriginalFilename());
				boardFileVO.setNum(boardVO.getNum());
				boardMapper.setFileWrite(boardFileVO);
			}
		}

		return rs;
	}

	public int setFileWrite(BoardFileVO boardFileVO) throws Exception
	{
		return boardMapper.setFileWrite(boardFileVO);
	}

	public BoardVO getDetail(BoardVO boardVO) throws Exception
	{
		return boardMapper.getDetail(boardVO);
	}

	public BoardFileVO getDetailFileDown(BoardFileVO boardFileVO) throws Exception
	{
		return boardMapper.getDetailFileDown(boardFileVO);
	}
}
