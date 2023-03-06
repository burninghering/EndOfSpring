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
		if(!loginCheck(request)) { //loginCheck�� true�� �ƴ϶��
			return "redirect:/login/login"; //login�� �������� login ȭ������ �̵� 
		}
		return "boardList"; //login�� ������ �Խ��� ȭ������ �̵�
	}

	private boolean loginCheck(HttpServletRequest request) {
		//1.������ ��
		HttpSession session = request.getSession();
		
		//2.���ǿ� id�� �ִ��� Ȯ��
//		if(session.getAttribute("id")!=null)
//			return true;
//		else
//			return false;
		
		return session.getAttribute("id")!=null; //null�� �ƴϸ� true, null�̸� false
	}
}
