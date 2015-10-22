package no.nith.pg5100.dao;

import no.nith.pg5100.dto.Address;
import no.nith.pg5100.dto.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.Assert.*;

public class CustomerDaoImplIT {
    private EntityManagerFactory factory;
    private EntityManager entityManager;
    private CustomerDaoImpl customerDao;

    @Before
    public void setUp() throws Exception {
        factory = Persistence.createEntityManagerFactory("customer");
        entityManager = factory.createEntityManager();
        customerDao = new CustomerDaoImpl(entityManager);
    }

    @After
    public void tearDown() throws Exception {
        entityManager.close();
        factory.close();
    }

    @Test
    public void persist() throws Exception {
        Address address = new Address();
        address.setStreet("Storgata");
        address.setCity("Oslo");
        Customer customer = new Customer();
        customer.setName("Per Olsen");
        customer.setEmail("perolsen@test.com");
        customer.setAddress(address);

        entityManager.getTransaction().begin();
        Customer result = customerDao.persist(customer);
        entityManager.getTransaction().commit();
        assertTrue(result.getId() > 0);
    }

    @Test
    public void getAll() throws Exception {
        List<Customer> customers = customerDao.getAll();
        assertNotNull(customers);
        assertEquals(1, customers.size());
    }
}