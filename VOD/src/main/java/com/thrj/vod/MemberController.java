package com.thrj.vod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thrj.Entity.Members;
import com.thrj.Mapper.MemberMapper;


@Controller
public class MemberController {

	@Autowired
	public MemberMapper mapper;
	
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
	
	@GetMapping("/login.do")
	public String login(@ModelAttribute Members vo, HttpServletRequest request){
		HttpSession session = request.getSession();

		boolean checkVO = mapper.logincheck(vo.getMb_id(),vo.getMb_pw());
		
		//로그인체크
		
		session.setMaxInactiveInterval(-1); 
		return "redirect:/index.do";
	}
	
	@GetMapping("/logincheck.do")
	@ResponseBody
	public Map<String, String> ajaxLogincheck(HttpServletRequest request
			, @RequestParam(value="id", required=false) String id
			, @RequestParam(value="pw", required=false) String pw) {
		
		Map<String, String> loginYnMap = new HashMap<String, String>();
		boolean check = false;
		check = mapper.logincheck(id, pw);
		if(check){
			loginYnMap.put("loginYn", "success");
		}else{
			loginYnMap.put("loginYn", "fail");
		}
		return loginYnMap;
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		session.removeAttribute("userId");
		session.invalidate();
		return "redirect:/index.do";

	}
	
	@RequestMapping(value="/signup.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView createUser(@ModelAttribute Members vo) {	
		ModelAndView mv = new ModelAndView();
        String mb_id = vo.getMb_id(); 
		Map<String, String> codeParam = new HashMap<String, String>();

		if(mb_id == null){
			//아이디없이  저장 버튼을 누를경우
			mv.setViewName("/signup");
		}else{

			//아이디를 넣고 저장 버튼을 누를 경우
			mv.setViewName("/signup");
		}
		return mv;
	}
	
	
	@RequestMapping(value="/deleteMember.do", method = {RequestMethod.GET, RequestMethod.POST})
	public void deleteUser(HttpServletRequest request, @ModelAttribute Members vo){
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
    	String mb_id = (String) session.getAttribute("mb_id"); 
		mapper.deleteMember(mb_id);;
		mv.setViewName("redirect:/index.do");
	}
	
	
	@RequestMapping(value="/updateMember.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateMember(HttpServletRequest request, @ModelAttribute Members vo){
			HttpSession session = request.getSession();
			ModelAndView mv = new ModelAndView();
			mapper.updateMember(vo);
			mv.setViewName("redirect:/index.do");
		return mv;
	}
	
	@RequestMapping(value="/member/saveFile.do", method=RequestMethod.POST)
	@ResponseBody
	public String saveFile(HttpServletRequest request ) throws IOException {
		//저장할 경로
		//서버체크 (로컬 / 실제서버)
		//단일파일업로드
		String imgFolder =""; //저장할 경로
		String realFolder = ""; //web-inf바로전 까지 저장할 경로
		//단일 파일경로
		String filename = "";//실제파일경로

		return filename;
	}

}

