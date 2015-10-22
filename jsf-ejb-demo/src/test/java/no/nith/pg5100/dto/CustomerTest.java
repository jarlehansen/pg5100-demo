package no.nith.pg5100.dto;

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
    public void validCustomer() throws Exception {
        Address address = new Address();
        address.setStreet("Storgata");
        address.setCity("Oslo");

        Customer customer = new Customer();
        customer.setName("Per Olsen");
        customer.setEmail("perolsen@test.com");
        customer.setAddress(address);

        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void missingAddress() throws Exception {
        Address address = new Address();
        Customer customer = new Customer();
        customer.setName("Per Olsen");
        customer.setEmail("perolsen@test.com");
        customer.setAddress(address);

        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(2, violations.size());
    }
}