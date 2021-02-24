package com.soft.demosoftunispring.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface Password {
    String message() default "Invalid password entered";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int maxValue() default  20;
    int minValue() default  6;
    boolean containsDigits() default true;
    boolean containsLowercase() default true;
    boolean containsUppercase() default false;
    boolean containsSpecialSymbols() default false;

}
