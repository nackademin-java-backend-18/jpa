package se.coredev.repository.jpa;

import se.coredev.data.ParkingSpot;
import se.coredev.repository.ParkingSpotRepository;
import se.coredev.repository.RepositoryException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

final class JpaParkingSpotRepository implements ParkingSpotRepository {

    private final EntityManagerFactory factory;

    JpaParkingSpotRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public ParkingSpot addParkingSpot(ParkingSpot parkingSpot) {
        EntityManager manager = factory.createEntityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(parkingSpot);
            manager.getTransaction().commit();

            return parkingSpot;
        } catch (PersistenceException e) {
            manager.getTransaction().rollback();
            throw new RepositoryException("Could not add parking spot: " + parkingSpot, e);
        } finally {
            manager.close();
        }
    }
}
