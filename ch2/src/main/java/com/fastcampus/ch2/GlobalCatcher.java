package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.fastcampus.ch2") //지정된 패키지 내에서 발생한 예외만 처리
public class GlobalCatcher {
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

}
