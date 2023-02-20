package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTeller {
	
	@RequestMapping("/getYoil")
	public  void main(HttpServletRequest request,HttpServletResponse response) throws IOException {
      
		
	// 1.입력 
	  String year = request.getParameter("year");
      String month = request.getParameter("month");
      String day = request.getParameter("day");

      int yyyy = Integer.parseInt(year);
      int mm = Integer.parseInt(month);
      int dd = Integer.parseInt(day);
      
    // 2.처리
      Calendar cal = Calendar.getInstance();
      cal.set(yyyy, mm - 1, dd);
      
      int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
      char yoil = " 일월화수목금토".charAt(dayOfWeek);   // 일요일:1, 월요일:2, ... 
     
    // 3.출력
      response.setContentType("text/html");
      response.setCharacterEncoding("utf-8");
      PrintWriter out = response.getWriter(); //response 객체에서 브라우저로의 출력 스트림을 얻는다
      out.println(year + "년 " + month + "월 " + day + "일은 ");
      out.println(yoil + "요일입니다.");
	}

}
