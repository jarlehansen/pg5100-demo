package no.nith.pg5100;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.Assert.*;

public class CustomerTest {
    private Validator validator;

    @Before
    public void setUp() throws Exception {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void valid() throws Exception {
        Customer customer = new Customer();
        customer.setId(15);
        customer.setUsername("hanjar");
        customer.setEmail("test@test.com");
        customer.setActive(true);

        customer.setCardNo("12345");
        customer.setExpirationDate(LocalDate.of(2020, 10, 10));

        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        System.out.println(violations);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void idTooLow() throws Exception {
        Customer customer = new Customer();
        customer.setId(3);

        Set<ConstraintViolation<Customer>> violations = validator.validateProperty(customer, "id");
        assertEquals(1, violations.size());
        System.out.println(violations.iterator().next().getMessage());
    }
}