package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.BAD_REQUEST) //<--500번에서 400번으로 바뀌게 함
class MyException extends RuntimeException{ //사용자 정의 예외 메소드
	MyException(String msg){ //기본 생성자는 필수
		super(msg);
	}
	
	MyException() {this("");}
}

@Controller
public class ExceptionController2 {
	
	@RequestMapping("/ex3")
	public String main() throws Exception {
			throw new MyException("예외가 발생했습니다."); //<--사용자가 정의한 예외를 던지는 코드로 변경
	}
	
	
	@RequestMapping("/ex4")
	public String main2() throws Exception {
			throw new FileNotFoundException("예외가 발생했습니다.");
	}
}
