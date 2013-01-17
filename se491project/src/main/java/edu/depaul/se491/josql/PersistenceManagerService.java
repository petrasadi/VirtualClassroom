package main.java.edu.depaul.se491.josql;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public final class PersistenceManagerService {
    private static final PersistenceManagerFactory pmfInstance =
        JDOHelper.getPersistenceManagerFactory("transactions-optional");

    private PersistenceManagerService() {}

    public static PersistenceManagerFactory get() {
        return pmfInstance;
    }
}
