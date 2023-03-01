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
	@RequestMapping(value="/register/add", method={RequestMethod.GET, RequestMethod.POST}) //POST�� GET��� �� �� �����ϵ��� �迭�� ���� 
	public String register() {
		return "registerForm"; //WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping("/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")
	public String save(User user,Model m) throws Exception {
		//1. ��ȿ�� �˻�
		if(!isValid(user)) {
			String msg =URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.","utf-8"); // -> ���� ó�� �ʿ� 
			
			//��ȿ���� ������ �ٽ� ȸ������ ȭ������
//			return "redirect:/register/add?msg="+msg; //URL ���ۼ� (rewriting) -> redirect�� msg�� ��������
			
			m.addAttribute("msg",msg);
			return "forward:/register/add";
		}
		//��ȿ�ϸ� ȸ�� ���� ȭ�� �����ֱ� 
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}
}
