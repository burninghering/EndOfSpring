//package com.fastcampus.ch3.diCopy4;
//
//import com.google.common.reflect.ClassPath;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import javax.annotation.Resource;
//import java.lang.reflect.Field;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//@Component class Car{
//    @Resource
//    Engine engine; //iv
//    @Resource
//    Door door; //iv
//
//    @Override
//    public String toString() {
//        return "Car{" +
//                "engine=" + engine +
//                ", door=" + door +
//                '}';
//    }
//}
//@Component class SportsCar extends Car{}
//
//@Component class Truck extends Car{}
//
//@Component class Engine{}
//
//@Component class Door{}
//
//class AppContext{
//    Map map; //객체 저장소
//
//    AppContext() {
//
//        map = new HashMap();
//        doComponentScan();
//        doAutowired();
//        doResource();
//    }
//
//    private void doResource() {
//        //map에 저장된 객체의 iv 중에 @Resource가 붙어있으면
//        //map에서 iv의 이름에 맞는 객체를 찾아서 연결(객체의 주소를 iv에 저장한다는 뜻)
//        try {
//            for(Object bean: map.values()){
//                for(Field fld:bean.getClass().getDeclaredFields()){
//                    if(fld.getAnnotation(Resource.class)!=null){ //by Name
//                        fld.set(bean,getBean(fld.getName())); //car에 engine이 있으면 obj를 넣어주는 것이다
//                    }
//                }
//            }
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void doAutowired(){
//        //map에 저장된 객체의 iv 중에 @Autowired가 붙어있으면
//        //map에서 iv의 타입에 맞는 객체를 찾아서 연결(객체의 주소를 iv에 저장한다는 뜻)
//        try {
//            for(Object bean: map.values()){
//                for(Field fld:bean.getClass().getDeclaredFields()){
//                    if(fld.getAnnotation(Autowired.class)!=null){ //by Type
//                        fld.set(bean,getBean(fld.getType())); //car에 engine이 있으면 obj를 넣어주는 것이다
//                    }
//                }
//            }
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void doComponentScan(){
//        try {
//            //1. 패키지 내의 클래스 목록을 가져온다.
//            //2. 반복문으로 클래스를 하나씩 읽어와서 @Component가 붙어있는지 확인
//            //3. @Component가 붙어있으면 객체를 생성해서 map에 저장
//            ClassLoader classLoader = AppContext.class.getClassLoader();
//            ClassPath classPath = ClassPath.from(classLoader);
//
//            Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.fastcampus.ch3.diCopy4");
//
//            for(ClassPath.ClassInfo classInfo:set){
//                Class clazz = classInfo.load();
//                Component component=(Component) clazz.getAnnotation(Component.class);
//                if(component!=null){
//                    String id= StringUtils.uncapitalize(classInfo.getSimpleName());
//                    map.put(id,clazz.newInstance());
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    //By Name 검색
//   Object getBean(String key){
//        return map.get(key);
//   }
//
//   //By Type 검색
//   Object getBean(Class clazz) {
//       for (Object obj : map.values()) { //map의 모든 value를 가져와서
//           if (clazz.isInstance(obj)) //obj가 class의 객체거나 자손이면 true가 됨
//               return obj;
//       }
//       return null;
//   }
//
//}
//
//public class Main4 {
//    public static void main(String[] args) throws Exception {
//        AppContext ac = new AppContext(); //객체 저장소 만들기
//
//        Car car = (Car) ac.getBean("car"); //byName으로 객체를 검색
//        Engine engine = (Engine) ac.getBean("engine");
//        Door door = (Door) ac.getBean(Door.class); //byType으로 객체를 검색
//
//        //수동으로 객체를 연결
////        car.engine=engine;
////        car.door=door;
//
//        System.out.println("car = " + car);
//        System.out.println("engine = " + engine);
//        System.out.println("door = " + door);
//    }
//}
