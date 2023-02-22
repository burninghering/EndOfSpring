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
		
	//1. ��ȿ�� �˻�
//	  if(!isValid(year,month,day)) 
//		  return "yoilError";
	  
	  //2. ���� ���
	  char yoil = getYoil(year, month, day);
	  
	  //3. ����� ����� �𵨿� ����
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
		// ó�� �κ��� �޼ҵ�� ������־���.
		  Calendar cal = Calendar.getInstance();
		  cal.set(year, month - 1, day);
		  
		  int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		  return " �Ͽ�ȭ�������".charAt(dayOfWeek);   // �Ͽ���:1, ������:2, ... 
	}

}
