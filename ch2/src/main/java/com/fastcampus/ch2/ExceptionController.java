package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model model) { 
		model.addAttribute("ex",ex); //모델로 넘겨주기
		return "error";
	}
	
	@ExceptionHandler({NullPointerException.class,FileNotFoundException.class}) //괄호 안에 배열을 넣어준다 
	public String catcher2(Exception ex,Model model) {
		model.addAttribute("ex", ex);
		return "error";
	}
	
	@RequestMapping("/ex")
	public String main() throws Exception {
			throw new Exception("예외가 발생했습니다.");
	}
	
	
	@RequestMapping("/ex2")
	public String main2() throws Exception {
			throw new FileNotFoundException("예외가 발생했습니다.");
	}
}
