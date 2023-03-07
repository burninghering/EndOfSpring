package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.fastcampus.ch2") //������ ��Ű�� ������ �߻��� ���ܸ� ó��
public class GlobalCatcher {
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model model) { 
		model.addAttribute("ex",ex); //�𵨷� �Ѱ��ֱ�
		return "error";
	}
	
	@ExceptionHandler({NullPointerException.class,FileNotFoundException.class}) //��ȣ �ȿ� �迭�� �־��ش� 
	public String catcher2(Exception ex,Model model) {
		model.addAttribute("ex", ex);
		return "error";
	}

}
