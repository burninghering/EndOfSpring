package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	//init 메소드란 서블릿이 초기화될 때 자동 호출되는 메소드
	//1. 서블릿의 초기화 작업 담당
	//2. 처음에 한번만 호출
	@Override
	public void init() throws ServletException {
		System.out.println("[HelloServlet] init() is called");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.입력
		//2.처리
		//3.출력
		System.out.println("[HelloServlet] service() is called");
	}
	
	
	//서블릿이 갱신되어서 리로딩 될 때
	//뒷정리 - 서블릿이 메모리에서 제거될 때 서블릿 컨테이너에 의해서 자동 호출
	@Override
	public void destroy() {
		System.out.println("[HelloServlet] destroy() is called");
	}


}
