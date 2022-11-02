package com.kjk.home.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.kjk.home.board.BoardFileVO;
import com.kjk.home.board.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileManageController
{
	@Autowired
	private BoardService boardService;

	@GetMapping(value = "/fileDown/{path}") // {path} : RestFul, RestAPI와 관련
	public ModelAndView fileDown(BoardFileVO boardFileVO, @PathVariable String path) throws Exception
	{// @pathVariable - String path를 {path}로 활용하겟다
		log.info("path: {}", path);
		ModelAndView mv = new ModelAndView();
		// DB에서 정보 조회
		if (path.equals("qna"))
		{
			boardFileVO = boardService.getDetailFileDown(boardFileVO);
		} else if (path.equals("notice"))
		{
			// noticeService 출력
		}

		mv.addObject("fileVO", boardFileVO);
		mv.addObject("path", path);
		mv.setViewName("fileManager");
		// BeanNameResolver :
		// view의 이름과 일치하는 bean의 이름이 있으면 해당 bean을 실행

		// InternalResourceViewResilver
		// /WEB-INF/views/fileManager.jsp

		return mv;
	}
}
