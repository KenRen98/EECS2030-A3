package org.eecs.a3.teamafk.MLS;
import java.util.HashMap;
import java.util.UUID;

/**
 * A Standard Singleton Cache
 */
public class SingletonCache {
    // @TODO: To be complete by students for caching layer
    private static SingletonCache INSTANCE = null;
    private static final HashMap<UUID, MLS> LocalCache = new HashMap<UUID, MLS>();

    private SingletonCache(){
    }

    /**
     * @return the instance of the Singleton
     * Create one and return it if it is null
     */
    public static synchronized SingletonCache getInstance()
    {
        if (SingletonCache.INSTANCE == null)
        {
            SingletonCache.INSTANCE = new SingletonCache();
        }
        return SingletonCache.INSTANCE;

    }

    /**
     * @param uuid The UUID needs to be searched
     * @return A instance of the Singleton
     * search from the singleton map by given ID
     */
    public MLS getByID(UUID uuid){
        return LocalCache.get(uuid);
    }

    /**
     * @param id The UUID needs to be placed
     * @param mls the corresponding MLS record that maps to the ID
     * Create a element in the singleton map
     */
    public void putValue(UUID id, MLS mls){
        LocalCache.put(id,mls);
    }
}
