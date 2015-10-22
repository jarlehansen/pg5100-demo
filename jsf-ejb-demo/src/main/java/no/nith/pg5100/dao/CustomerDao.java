package no.nith.pg5100.dao;

import no.nith.pg5100.dto.Customer;

import java.util.List;

public interface CustomerDao {
    Customer persist(Customer customer);
    List<Customer> getAll();
}
