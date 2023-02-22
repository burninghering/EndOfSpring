package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class YoilTellerMVC {
	
	@RequestMapping("/getYoilMVC")
	public ModelAndView main(int year, int month, int day) throws IOException {  
		
		ModelAndView mv = new ModelAndView();
		
	//1. 유효성 검사
//	  if(!isValid(year,month,day)) 
//		  return "yoilError";
	  
	  //2. 요일 계산
	  char yoil = getYoil(year, month, day);
	  
	  //3. 계산한 결과를 모델에 저장
	  mv.addObject("year", year);
	  mv.addObject("month", month);
	  mv.addObject("day", day);
	  mv.addObject("yoil", yoil);
	  
	  mv.setViewName("yoil");
	  
	  return mv;
	}

	private boolean isValid(int year, int month, int day) {
		return true;
	}

	private char getYoil(int year, int month, int day) {
		// 처리 부분을 메소드로 만들어주었다.
		  Calendar cal = Calendar.getInstance();
		  cal.set(year, month - 1, day);
		  
		  int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		  return " 일월화수목금토".charAt(dayOfWeek);   // 일요일:1, 월요일:2, ... 
	}

}
