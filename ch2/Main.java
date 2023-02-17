package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws Exception{

//		Hello hello = new Hello();
//		hello.main(); //private�� �ܺ� ȣ�� �Ұ�
		
		//Reflection API�� ��� - Ŭ���� ������ ��� �ٷ� �� �ִ� ������ ��� ����
		//java.lang.reflect ��Ű���� ����
		
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		//Hello Ŭ������ Class ��ü(Ŭ������ ������ ��� �ִ� ��ü)�� ���´�. (���赵)
		
		Hello hello = (Hello)helloClass.newInstance(); //Ŭ���� ��ü�� ���� ������ ��ü ����
		Method main = helloClass.getDeclaredMethod("main"); //�޼ҵ带 ������ �� Method�� ���
		main.setAccessible(true); //private�� main()�� ȣ�� �����ϰ� �Ѵ�.
		
		main.invoke(hello); //���� �޼ҵ� �����ϱ�, hello.main()
		
		//��������� �ٸ� Ŭ�������� �ٸ� Ŭ������ �޼ҵ带 ������ ���� 
	}

}
