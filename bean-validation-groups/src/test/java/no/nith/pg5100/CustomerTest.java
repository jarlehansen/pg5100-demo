package no.nith.pg5100;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Set;

import static org.junit.Assert.*;

public class CustomerTest {
    private Validator validator;

    @Before
    public void setUp() throws Exception {
         validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void firstNameAndLastName() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("Ola");
        customer.setLastName("Nordmann");

        Set<ConstraintViolation<Customer>> violations = validator.validate(customer, Name.class);
        System.out.println(violations);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void age() throws Exception {
        Customer customer = new Customer();
        customer.setAge(20);

        Set<ConstraintViolation<Customer>> violations = validator.validate(customer, Age.class);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void age_property() throws Exception {
        Customer customer = new Customer();
        customer.setAge(20);

        Set<ConstraintViolation<Customer>> violations = validator.validateProperty(customer, "age");
        assertTrue(violations.isEmpty());
    }
}