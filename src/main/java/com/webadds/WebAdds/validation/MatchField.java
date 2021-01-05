package com.webadds.WebAdds.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=FieldMatchValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MatchField {

	public String firstFieldName();
	
	public String secondFieldName();
	
	public String message() default "Fields did not match";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
