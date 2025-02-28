package com.challenge.amountValidator.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AmountValidator.class)
@Documented
public @interface Amount {
	String message() default "${validatedValue.amount} is not a valid amount";

	String value() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}