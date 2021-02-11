package app.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsEnglishValidator.class)
public @interface IsEnglish {

    String message() default "{ppk.validator.constraint.isEnglish.format}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
