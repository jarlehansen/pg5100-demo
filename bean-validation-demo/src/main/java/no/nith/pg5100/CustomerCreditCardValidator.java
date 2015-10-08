package no.nith.pg5100;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class CustomerCreditCardValidator implements ConstraintValidator<CustomerCreditCard, Customer> {

    @Override
    public void initialize(CustomerCreditCard customerCreditCard) {
    }

    @Override
    public boolean isValid(Customer customer, ConstraintValidatorContext constraintValidatorContext) {
        String cardNo = customer.getCardNo();
        if(cardNo == null)
            return true;

        LocalDate expirationDate = customer.getExpirationDate();
        return expirationDate.isAfter(LocalDate.now());

    }
}
