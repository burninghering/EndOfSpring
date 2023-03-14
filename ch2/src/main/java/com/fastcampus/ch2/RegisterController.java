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
		
//		binder.setValidator(new UserValidator()); //UserValidator�� WebDataBinder�� ���� validator�� ���
		
//		binder.addValidators(new UserValidator()); //set���� �ϸ� local�� ���� �ǹǷ� add�� �ٲ��ش�

		
		List<Validator> validatorList = binder.getValidators(); //��ϵ� ������� ��������
		System.out.println("validatorList="+validatorList);
	}
	
	@RequestMapping(value="/register/add", method={RequestMethod.GET, RequestMethod.POST}) //POST�� GET��� �� �� �����ϵ��� �迭�� ���� 
	public String register() {
		return "registerForm"; //WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping("/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")
	public String save(@Valid User user,BindingResult result, Model m) throws Exception {
		
		System.out.println("result="+result);
		System.out.println("User="+user);
//		
//		UserValidator userValidator = new UserValidator(); //userValidator�� �����ؼ�
//		userValidator.validate(user, result); //BindingResult�� Errors�� �ڼ� //������ �� ��
		
		//User��ü�� ������ ��� ������ ������, registerForm�� �̿��ؼ� ������ �����־�� �Ѵ�. 
		if(result.hasErrors()) { //���� ����� ��� result�� ������ �ִٸ�
			return "registerForm";
		}
		
		
		
		
//		//1. ��ȿ�� �˻�
//		if(!isValid(user)) {
//			String msg =URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.","utf-8"); // -> ���� ó�� �ʿ� 
//			
//			//��ȿ���� ������ �ٽ� ȸ������ ȭ������
////			return "redirect:/register/add?msg="+msg; //URL ���ۼ� (rewriting) -> redirect�� msg�� ��������
//			
//			m.addAttribute("msg",msg);
//			return "forward:/register/add";
//		}
		//��ȿ�ϸ� ȸ�� ���� ȭ�� �����ֱ� 
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
}
