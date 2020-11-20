package tntgroup.inlife.database;

/**
 * Singleton for database of application
 */
public class Database {

    /**
     * Unique instance of class
     */
    private static volatile Database instance;

    /**
     * Get unique instance of {@link Database} class
     * (Double Check Locking)
     *
     * @return instance on singleton
     */
    public static Database getInstance() {
        Database localInstance = instance;
        if (localInstance == null) {
            synchronized (Database.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Database();
                }
            }
        }
        return localInstance;
    }
}
