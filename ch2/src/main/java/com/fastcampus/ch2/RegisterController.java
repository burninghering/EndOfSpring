package com.fastcampus.ch2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	@RequestMapping(value="/register/add", method={RequestMethod.GET, RequestMethod.POST}) //POST와 GET방식 둘 다 가능하도록 배열에 넣음 
	public String register() {
		return "registerForm"; //WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping("/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")
	public String save(User user,Model m) throws Exception {
		//1. 유효성 검사
		if(!isValid(user)) {
			String msg =URLEncoder.encode("id를 잘못입력하셨습니다.","utf-8"); // -> 예외 처리 필요 
			
			//유효하지 않으면 다시 회원가입 화면으로
//			return "redirect:/register/add?msg="+msg; //URL 재작성 (rewriting) -> redirect에 msg를 전달해줌
			
			m.addAttribute("msg",msg);
			return "forward:/register/add";
		}
		//유효하면 회원 정보 화면 보여주기 
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}
}
