package com.thrj.vod;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thrj.Entity.Comments;
import com.thrj.Entity.Movies;
import com.thrj.Mapper.CommentsMapper;
import com.thrj.Mapper.MovieMapper;


@Controller
public class MovieController {
	
	@Autowired
	public MovieMapper mapper;
	
	@Autowired
	public CommentsMapper cmt_mapper;
	
	@GetMapping(value={"/index.do","/"})
	public String index(Model model) {
		List<Movies> list = mapper.movieList();
		model.addAttribute("list",list);
		
		List<Movies> list_1 = mapper.bannerList();
	      model.addAttribute("list_1",list_1);
		return "index";
	}
	
	@RequestMapping(value="/animeDetails.do", method=RequestMethod.GET)
	public ModelAndView animeDetails(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		int movieSeq = Integer.parseInt(request.getParameter("movie_seq")) ;
		
		mapper.raiseLookupCount(movieSeq); //영화 게시물 view수
		Movies movie=mapper.animeDetails(movieSeq); //내용 시나리오
		int Comments_cnt=cmt_mapper.CommentsCnt(movieSeq); //댓글수
	    List<Comments> list = cmt_mapper.getAllCommentsByPage(movieSeq); //게시물수
		
		mv.addObject("CommentList",list);
		mv.addObject("CommentsCnt",Comments_cnt);
		mv.addObject("movie", movie);
		mv.setViewName("anime-details");
		return mv;
	}
	
	@GetMapping("/animeWatching.do")
	public String animeWatching() {
		
		return "anime-watching";
	}
	
	@GetMapping("/blog.do")
	public String blog() {
		
		return "blog";
	}
	
	@GetMapping("/blogDetails.do")
	public String blogDetails() {
		
		return "blog-details";
	}
	
	@GetMapping("/categories.do")
	public String categories(Model model) {
		List<Movies> list = mapper.movieList();
		model.addAttribute("list",list);
		return "categories";
	}
	
	@RequestMapping(value="/CommentWrite.do", method = RequestMethod.POST)
	public String CommentWrite(@ModelAttribute Comments vo) {
		cmt_mapper.createComments(vo);
		return "redirect:/animeDetails.do?movie_seq="+vo.getMovie_seq();
	}
}