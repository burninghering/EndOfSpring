package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1.���� ȣ�� ������ ���α׷����� ���
@Controller
public class Hello {
	
	int iv=10;
	static int cv =20;
	
	//2.URL�� �޼��带 ����
	@RequestMapping("/hello")
	private void main() { //�ν��Ͻ� �޼ҵ� - iv, cv �� �� ��� ����
		System.out.println("Hello");
	}
	
	public static void main2() { //static �޼ҵ� - cv�� ��� ����
		System.out.println(cv);
//		System.out.println(iv); //����
	}

}
