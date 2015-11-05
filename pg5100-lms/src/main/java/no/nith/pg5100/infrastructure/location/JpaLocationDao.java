package no.nith.pg5100.infrastructure.location;

import no.nith.pg5100.dto.Location;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaLocationDao implements LocationDao {

    @PersistenceContext(unitName = "pg5100-lms")
    private EntityManager entityManager;

    public JpaLocationDao() {
    }

    JpaLocationDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Location persist(Location location) {
        entityManager.persist(location);
        return location;
    }

    @Override
    public Location findById(int id) {
        return entityManager.find(Location.class, id);
    }

    @Override
    public List<Location> getAll() {
        TypedQuery<Location> query = entityManager.createNamedQuery("Location.getAll", Location.class);
        return query.getResultList();
    }
}
