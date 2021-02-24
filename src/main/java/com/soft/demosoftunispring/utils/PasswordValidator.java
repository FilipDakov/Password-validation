package com.soft.demosoftunispring.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    private int maximum;
    private int minimum;
    private boolean lowercase;
    private boolean uppercase;
    private boolean specialCharacters;
    private boolean digits;

    public void initialize(Password constraint) {
        maximum = constraint.maxValue();
        minimum = constraint.minValue();
        lowercase = constraint.containsLowercase();
        uppercase= constraint.containsUppercase();
        digits = constraint.containsDigits();
        specialCharacters = constraint.containsSpecialSymbols();
    }

    public boolean isValid(String obj, ConstraintValidatorContext context)
    {

        if(obj.length() > maximum || obj.length() < minimum){
            return  false;
        }
        if(!specialCharacters && !uppercase ){
            return validate("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d].{0,}$",obj);

        }else if(!specialCharacters && uppercase ){
            return validate("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d].{0,}$",obj);

        }else if(!uppercase && specialCharacters){
            return  validate("^(?=.*\\d)(?=.*[a-z])(?=.*[^a-zA-Z0-9])(?!.*\\s).{0,}$)", obj);
        }
        else{
            return  validate("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\\s).{0,}$)",obj);
        }

    }

    private boolean validate(String regex,String obj){
        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(obj);
        return matcher.matches();

    }
}
