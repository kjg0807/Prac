package com.kjk.home.board;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		// mv.addObject("pager", pager);
		mv.setViewName("board/list");

		return mv;
	}

	@GetMapping("write")
	public String getWrite(@ModelAttribute BoardVO boardVO) throws Exception
	{
		log.info("=== get Write ===");

		return "board/write";
	}

	@PostMapping("write")
	public ModelAndView write(ModelAndView mv, @Valid BoardVO boardVO, BindingResult bindingResult, RedirectAttributes redirectAttributes)
			throws Exception
	{
		log.info("=== Post write ===");

		// if (bindingResult.hasErrors())
		// {
		// log.info("===== qna write error =====");
		// mv.setViewName("board/write");
		// return mv;
		// }

		int rs = boardService.setWriteList(boardVO);

		redirectAttributes.addAttribute("rs", rs);
		mv.setViewName("redirect:./list");

		return mv;
	}

	@GetMapping(value = "detail")
	public ModelAndView getDetail(BoardVO boardVO) throws Exception
	{
		log.info("=== get Detail === ");
		ModelAndView mv = new ModelAndView();

		boardVO = boardService.getDetail(boardVO);

		mv.addObject("boVO", boardVO);
		mv.setViewName("board/detail");

		return mv;
	}
}
