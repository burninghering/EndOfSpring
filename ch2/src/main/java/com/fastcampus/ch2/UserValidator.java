package com.fastcampus.ch2;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


	public class UserValidator implements Validator {
		@Override
		public boolean supports(Class<?> clazz) {
//			return User.class.equals(clazz); // 검증하려는 객체가 User타입인지 확인
			return User.class.isAssignableFrom(clazz); // clazz가 User 또는 그 자손인지 확인
		}

		@Override
		public void validate(Object target, Errors errors) { 
			System.out.println("UserValidator.validate() is called");

			User user = (User)target;
			
			String id = user.getId();
			
	//		if(id==null || "".equals(id.trim())) {
	//			errors.rejectValue("id", "required");
	//		}
			
			//id가 null이거나 공백일 때 그런 경우에는 errors객체에 필드이름을 id라고 하고, 에러코드를 required라고 저장해라
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id",  "required"); 
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
			
			
			//id가 5자보다 작거나 12자보다 길때는 invalidLength라는 에러코드로 저장해라
			if(id==null || id.length() <  5 || id.length() > 12) {
				errors.rejectValue("id", "invalidLength");
			}
		}
	}

