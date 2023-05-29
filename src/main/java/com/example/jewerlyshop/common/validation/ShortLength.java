package com.example.jewerlyshop.common.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = ShortLengthValidator.class)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface ShortLength {
    String message() default "{com.example.jewerlyshop.common.validation.DigitLength.message}";
    int value();

    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}
