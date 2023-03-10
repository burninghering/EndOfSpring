package com.fastcampus.ch2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	@GetMapping("/list")
	public String list(HttpServletRequest request) {
		if(!loginCheck(request)) { //loginCheck가 true가 아니라면
			return "redirect:/login/login?toURL="+request.getRequestURL(); //login화면에 GET방식으로 데이터를 주는 것
		}
		return "boardList"; //login을 했으면 게시판 화면으로 이동
	}

	private boolean loginCheck(HttpServletRequest request) {
		//1.세션을 얻어서
		HttpSession session = request.getSession();
		
		//2.세션에 id가 있는지 확인
//		if(session.getAttribute("id")!=null)
//			return true;
//		else
//			return false;
		
		return session.getAttribute("id")!=null; //null이 아니면 true, null이면 false
	}
}
