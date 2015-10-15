package no.nith.pg5100;

import no.nith.pg5100.embedded.ContactInfo;
import no.nith.pg5100.embedded.Person;
import no.nith.pg5100.many_to_many.Album;
import no.nith.pg5100.many_to_many.Artist;
import no.nith.pg5100.one_to_many.Order;
import no.nith.pg5100.one_to_many.OrderLine;
import no.nith.pg5100.one_to_one.Address;
import no.nith.pg5100.one_to_one.Customer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class JpaIT {
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    @Before
    public void setUp() throws Exception {
        factory = Persistence.createEntityManagerFactory("jpa-relationships");
        entityManager = factory.createEntityManager();
    }

    @After
    public void tearDown() throws Exception {
        entityManager.close();
        factory.close();
    }

    @Test
    public void embedded() throws Exception {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setPhoneNumber("12345678");

        Person person = new Person();
        person.setName("Mari");
        person.setContactInfo(contactInfo);

        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        assertTrue(person.getId() > 0);
    }

    @Test
    public void oneToOne() throws Exception {
        Address address = new Address();
        address.setCity("Oslo");
        address.setStreet("Karl johan");

        Customer customer = new Customer();
        customer.setFirstName("Kari");
        customer.setLastName("Olsen");
        customer.setAddress(address);

        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        assertTrue(customer.getId() > 0);
    }

    @Test
    public void oneToMany() throws Exception {
        OrderLine orderLine = new OrderLine();
        orderLine.setItem("Java EE 7 book");

        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(orderLine);

        Order order = new Order();
        order.setCreationDate(new Date());
        order.setOrderLines(orderLines);

        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
        assertTrue(order.getId() > 0);
    }

    @Test
    public void manyToMany() throws Exception {
        Album album = new Album();
        album.setTitle("black album");
        List<Album> albums = new ArrayList<>();
        albums.add(album);

        Artist artist = new Artist();
        artist.setName("metallica");
        artist.setAlbums(albums);
        List<Artist> artists = new ArrayList<>();
        artists.add(artist);
        album.setArtists(artists);

        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
        assertTrue(album.getId() > 0);
    }
}
