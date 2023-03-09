package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model model) { 
		model.addAttribute("ex",ex);
		return "error"; //<--응답 상태 코드를 200번으로 보여줌
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //에러 상태코드를 500번으로 바꿔줌
	@ExceptionHandler({NullPointerException.class,FileNotFoundException.class}) 
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
