package no.nith.pg5100;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class CustomerDaoIT {
    private EntityManagerFactory factory;
    private EntityManager entityManager;
    private CustomerDao customerDao;

    @Before
    public void setUp() throws Exception {
        factory = Persistence.createEntityManagerFactory("customer");
        entityManager = factory.createEntityManager();
        customerDao = new CustomerDao(entityManager);
    }

    @After
    public void tearDown() throws Exception {
        entityManager.close();
        factory.close();
    }

    @Test
    public void persist() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("Ola");
        customer.setLastName("Nordmann");
        customer.setAge(20);

        entityManager.getTransaction().begin();
        Customer result = customerDao.persist(customer);
        entityManager.getTransaction().commit();
        System.out.println(result.getId());
        assertTrue(result.getId() > 0);
    }

    @Test
    public void delete() throws Exception {
        Customer customer = customerDao.findById(123);
        boolean deleted = customerDao.delete(customer);
        assertTrue(deleted);
    }

    @Test
    public void findByFirstName() throws Exception {
        List<Customer> customers = customerDao.findByFirstName("Ola");
        System.out.println(customers);
        assertTrue(customers.size() > 0);
    }
}