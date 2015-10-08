package no.nith.pg5100;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerDao {
    private EntityManager entityManager;

    public CustomerDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Customer persist(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

    public boolean delete(Customer customer) {
        entityManager.remove(customer);
        return true;
    }

    public Customer findById(int id) {
        return entityManager.find(Customer.class, id);
    }

    public List<Customer> findByFirstName(String firstName) {
        TypedQuery<Customer> query = entityManager.createNamedQuery("Customer.findByFirstName", Customer.class);
        query.setParameter("firstName", firstName);
        return query.getResultList();
    }
}
