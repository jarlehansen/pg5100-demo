package no.nith.pg5100.controller;

import no.nith.pg5100.dao.CustomerDao;
import no.nith.pg5100.dto.Address;
import no.nith.pg5100.dto.Customer;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class CustomerController {
    private final CustomerDao customerDao;
    private Customer customer;

    @Inject
    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @PostConstruct
    public void init() {
        Address address = new Address();
        customer = new Customer();
        customer.setAddress(address);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void persist() {
        customerDao.persist(customer);
    }

    public List<Customer> getAll() {
        return customerDao.getAll();
    }
}
