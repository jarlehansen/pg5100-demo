package no.nith.pg5100;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CustomerCreditCardValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomerCreditCard {
    String message() default "Invalid credit card";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
