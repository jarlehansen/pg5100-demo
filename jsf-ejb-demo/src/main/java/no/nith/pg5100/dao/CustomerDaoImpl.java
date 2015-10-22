package no.nith.pg5100.dao;

import no.nith.pg5100.dto.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CustomerDaoImpl implements CustomerDao {
    @PersistenceContext(unitName = "customer")
    private EntityManager entityManager;

    public CustomerDaoImpl() {
    }

    CustomerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Customer persist(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        TypedQuery<Customer> query = entityManager.createNamedQuery("Customer.getAll", Customer.class);
        return query.getResultList();
    }
}
