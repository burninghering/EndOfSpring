package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//1.������ ����
		session.invalidate();
		//2.Ȩ���� �̵�
		return "redirect:/";
	}
	
	
	@PostMapping("/login")
	public String login(String id,String pwd,boolean rememberId,
			HttpServletRequest request, String toURL,
			HttpServletResponse response) throws Exception {		
		
		//1. ���̵�� �н����� Ȯ��
		//2-1. ��ġ���� ������ loginForm���� �̵�
	
		if (!loginCheck(id,pwd)) {
			String msg=URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.","utf-8");
			
			return "redirect:/login/login?msg="+msg;
		}
		
		//2-2. ���̵�� �н����尡 ��ġ�ϸ�,
		//���� ��ü�� ������
		HttpSession session = request.getSession();
		// ���� ��ü�� id�� ����
		session.setAttribute("id", id);
		
		if(rememberId) {
			//��Ű�� ����
			//	1. ��Ű�� ����
			Cookie cookie =new Cookie("id",id);
			//  2. ���信 ����
			response.addCookie(cookie);
			
		}else {
			//��Ű�� ���� 
			Cookie cookie =new Cookie("id",id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		//	3. Ȩ���� �̵�
		
		toURL = toURL==null || toURL.equals("") ? "/" : toURL; 
		//toURL�� ���� ����� �Ѿ���� �ʴ´ٸ� (null�̰ų�, �� ���ڿ��̸�) Ȩ���� ���� �ϰ� �׷��� ������ toURL�� 
		
		return "redirect:"+toURL;
	}

	private boolean loginCheck(String id, String pwd) {
		
		return "asdf".equals(id) && "1234".equals(pwd);
	}
}


