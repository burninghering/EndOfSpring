package com.fastcampus.ch3.diCopy1;

import java.io.FileReader;
import java.util.Properties;

import static java.lang.Class.forName;

class Car{}
class SportsCar extends Car{}

class Truck extends Car{}
class Engine{}
public class Main1 {
    public static void main(String[] args) throws Exception {
        Car car = (Car)getObject("car");
        Engine engine = (Engine) getObject("engine");
        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
    }

    static Object getObject(String key) throws Exception{
        Properties p = new Properties();
        p.load(new FileReader("config.txt"));

        Class clazz = Class.forName(p.getProperty(key)); //key를 이용해서 클래스의 정보를 얻어오고

        return clazz.newInstance(); //그것의 객체를 생성해서 반환한다.
    }

    static Car getCar() throws Exception{
        Properties p = new Properties();
        p.load(new FileReader("config.txt"));

        Class clazz = Class.forName(p.getProperty("car"));

        return (Car)clazz.newInstance();
    }
}
