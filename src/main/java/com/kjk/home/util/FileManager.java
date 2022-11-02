package com.kjk.home.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.kjk.home.board.BoardFileVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileManager extends AbstractView
{
	@Value("${app.download.base}")
	private String base;
	// -> app.download.base=D:/GDRS/upload/
	// -> app.download.base=/resource/upload/
	// -> 다운로드 경로

	@Override // 다운로드 걸어주는 메서드
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		BoardFileVO boardFileVO = (BoardFileVO) model.get("fileVO");
		String path = (String) model.get("path");
		log.info("------------------------------------------------------");
		log.info("FILEVO: {}", boardFileVO);

		// base: 다운로드 경로, path: jsp에서 다운시 경로 /fileDown/{path}
		// boardFileVO.getFileName() : 파일 이름
		File file = new File(base + path, boardFileVO.getFileName());

		// 한글 처리
		response.setCharacterEncoding("UTF-8");
		// 파일의 크기
		response.setContentLengthLong(file.length());
		// 다운로드시 파일의 이름을 인코딩 - URLEncoder : java.net
		String oriName = URLEncoder.encode(boardFileVO.getOriName(), "UTF-8");
		// header 설정 - 파일 형식?
		response.setHeader("Content-Disposition", "attachment;filename=\"" + oriName + "\"");
		response.setHeader("Content-Transfer-Encoding", "binary");

		// HDD에서 파일을 읽고
		FileInputStream fi = new FileInputStream(file);
		// Client로 전송
		OutputStream os = response.getOutputStream();

		// 전송
		FileCopyUtils.copy(fi, os);

		// 자원해제
		os.close();
		fi.close();
	}

	// cmd창에서 저장될 파일 이름
	public String saveFile(MultipartFile mf, String path) throws IOException
	{
		// 1. 중복되지 않는 파일 명 생성(UUID, Date)
		String fileName = UUID.randomUUID().toString();

		// 2. 확장자 - MultipartFile의 orginal Filename
		StringBuffer bf = new StringBuffer();
		bf.append(fileName);
		bf.append("_");
		bf.append(mf.getOriginalFilename());
		// log.info("FileName: {}", bf.toString());

		// 3. File 저장하기
		File file = new File(path, bf.toString());

		// FileCopyUtils
		// FileCopyUtils.copy(mf.getBytes(), file);

		// MultipartFile
		mf.transferTo(file);

		return bf.toString();
		// buffer인 bf 전체를 문자열로 리턴
	}
}
