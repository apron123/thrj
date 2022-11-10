package kr.thrj.vod;

import org.springframework.web.bind.annotation.RequestMapping;

public class WebController {
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
}
