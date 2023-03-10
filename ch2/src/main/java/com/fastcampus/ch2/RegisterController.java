package com.fastcampus.ch2;



import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		
//		ConversionService conversionService = binder.getConversionService();
//		System.out.println("conversionService="+conversionService);
		
//		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df,false));
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
		
//		binder.setValidator(new UserValidator()); //UserValidator를 WebDataBinder의 로컬 validator로 등록
		
//		binder.addValidators(new UserValidator()); //set으로 하면 local을 쓰게 되므로 add로 바꿔준다

		
		List<Validator> validatorList = binder.getValidators(); //등록된 검증기들 가져오기
		System.out.println("validatorList="+validatorList);
	}
	
	@RequestMapping(value="/register/add", method={RequestMethod.GET, RequestMethod.POST}) //POST와 GET방식 둘 다 가능하도록 배열에 넣음 
	public String register() {
		return "registerForm"; //WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping("/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")
	public String save(@Valid User user,BindingResult result, Model m) throws Exception {
		
		System.out.println("result="+result);
		System.out.println("User="+user);
//		
//		UserValidator userValidator = new UserValidator(); //userValidator를 생성해서
//		userValidator.validate(user, result); //BindingResult는 Errors의 자손 //검증을 한 뒤
		
		//User객체를 검증한 결과 에러가 있으면, registerForm을 이용해서 에러를 보여주어야 한다. 
		if(result.hasErrors()) { //검증 결과가 담긴 result에 에러가 있다면
			return "registerForm";
		}
		
		
		
		
//		//1. 유효성 검사
//		if(!isValid(user)) {
//			String msg =URLEncoder.encode("id를 잘못입력하셨습니다.","utf-8"); // -> 예외 처리 필요 
//			
//			//유효하지 않으면 다시 회원가입 화면으로
////			return "redirect:/register/add?msg="+msg; //URL 재작성 (rewriting) -> redirect에 msg를 전달해줌
//			
//			m.addAttribute("msg",msg);
//			return "forward:/register/add";
//		}
		//유효하면 회원 정보 화면 보여주기 
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
}
