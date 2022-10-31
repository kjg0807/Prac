package com.kjk.home.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kjk.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/board/*")
public class BoardController
{
	@Autowired
	private BoardService boardService;

	@GetMapping(value = "list")
	public ModelAndView getList(Pager pager) throws Exception
	{
		log.info("GET LIST");
		ModelAndView mv = new ModelAndView();
		List<BoardVO> ar = boardService.getList(pager);

		mv.addObject("ar", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");

		return mv;
	}
}
