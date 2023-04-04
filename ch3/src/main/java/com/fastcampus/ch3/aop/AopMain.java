package com.fastcampus.ch3.aop;

import org.checkerframework.checker.units.qual.A;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AopMain {
    public static void main(String[] args) throws Exception{
         MyAdvice myAdvice=new MyAdvice();

         Class myClass = Class.forName("com.fastcampus.ch3.aop.MyClass");
         Object obj = myClass.newInstance();

         for(Method m : myClass.getDeclaredMethods()){ //myClass에 정의된 메소드를 배열로 받아와서 하나씩 얻어온다
             myAdvice.invoke(m,obj,null); //myClass에 선언된 메소드가 하나씩 넘어가게 된다.
        }
      }
    }

class MyAdvice{
    Pattern p = Pattern.compile("a.*"); //정규식을 이용해, 메소드가 a로 시작하는 것만 골라서 아래 코드를 추가해본다

    boolean matchs(Method m){
        Matcher mather = p.matcher(m.getName());
        return mather.matches();
    }

    void invoke(Method m, Object obj, Object... args) throws Exception{

        if(m.getAnnotation(Transactional.class)!=null)
            System.out.println("[before]{");
        m.invoke(obj, args); //aaa() aaa2() aaa3() 호출 가능
        if(m.getAnnotation(Transactional.class)!=null)
            System.out.println("}[after]");
    }
}

    class MyClass{

        @Transactional
        void aaa(){
            System.out.println("aaa is called.");
        }
        void aaa2(){
            System.out.println("aaa2 is called.");
        }
        void bbb3(){
            System.out.println("bbb3 is called.");
        }
    }

