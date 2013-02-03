package edu.depaul.se491.josql;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * {@literal}
 * class EntityManagerService is a factory service for creating new EntityManagerFactory
 *
 * @author Adrian Petras <petrasadi@gmail.com>
 *         Andy Soderstrom <asoderst@gmail.com>
 *         Casey Benzel <casey.benzel@gmail.com>
 *         Elizabeth Stovall <emstovall@gmail.com>
 *         James Raitsev <raitsev@gmail.com>
 * @return EntityManagerFactory
 */
public class EntityManagerService
{
    private static final EntityManagerFactory entityManager = Persistence
            .createEntityManagerFactory("transactions-optional");

    private EntityManagerService()
    {
    }

    public static EntityManagerFactory get()
    {
        return entityManager;
    }
}
