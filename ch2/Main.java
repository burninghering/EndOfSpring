package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws Exception{

//		Hello hello = new Hello();
//		hello.main(); //private라 외부 호출 불가
		
		//Reflection API를 사용 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능 제공
		//java.lang.reflect 패키지를 제공
		
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		//Hello 클래스의 Class 객체(클래스의 정보를 담고 있는 객체)를 얻어온다. (설계도)
		
		Hello hello = (Hello)helloClass.newInstance(); //클래스 객체가 가진 정보로 객체 생성
		Method main = helloClass.getDeclaredMethod("main"); //메소드를 참조할 때 Method를 사용
		main.setAccessible(true); //private인 main()을 호출 가능하게 한다.
		
		main.invoke(hello); //메인 메소드 참조하기, hello.main()
		
		//결과적으로 다른 클래스에서 다른 클래스의 메소드를 참조한 것임 
	}

}
