package com.thrj.vod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thrj.Entity.Members;
import com.thrj.Mapper.MovieMapper;

@Controller
public class MovieController {
	
	@Autowired
	public MovieMapper mapper;
	
	@GetMapping("/")
	public String main() {
		
		return "index";
	}
	
	@GetMapping("/index.do")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/animeDetails.do")
	public String animeDetails() {
		
		return "anime-details";
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
	public String categories() {
		
		return "categories";
	}
	
	@GetMapping("/login.do")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/signup.do")
	public String signup() {
		
		return "signup";
	}
	
	
	
	
	//	Test
	@GetMapping("/test.do")
	public String test(Model model) {
		Members vo = mapper.idCheck("mb_id 001");
		model.addAttribute("vo", vo);
		return "test";
	}
	
	@PostMapping("/idCheck.do")
	public @ResponseBody Members idCheck(String mb_id) {
		
		// Mapper.interface, Mapper.xml
		// 해당 id가 존재하면 회원정보(id, pw, nick, addr)를 받아오고
		// 해당 id가 존재하지 않으면 null
		Members vo = mapper.idCheck(mb_id);

		if(vo == null) {
			vo = new Members();
			vo.setMb_id("null");
		}
		
		return vo;
	}
	
}
