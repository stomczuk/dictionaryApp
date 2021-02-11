package app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsEnglishValidator implements ConstraintValidator<IsEnglish, String> {

    @Override
    public void initialize(IsEnglish constraintAnnotation) {

    }

    @Override
    public boolean isValid(String word, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
