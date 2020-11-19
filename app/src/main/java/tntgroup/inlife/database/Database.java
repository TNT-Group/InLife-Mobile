package tntgroup.inlife.database;

import java.util.Arrays;
import java.util.List;

import tntgroup.inlife.messenger.MessageGroup;
import tntgroup.inlife.messenger.MessengerFragment;
import tntgroup.inlife.R;

/**
 * Singleton for database of application
 */
public class Database {

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

    /**
     * Get message groups for {@link MessengerFragment}'s
     * list (which is {@link androidx.recyclerview.widget.RecyclerView})
     * for current user
     *
     * @return list of message groups
     */
    public List<MessageGroup> getMessageGroups() {
        MessageGroup messageGroup = new MessageGroup(
                0, "Hello World!",
                false, "Surname Name",
                R.drawable.ic_navigation_love
        );
        return Arrays.asList(
                messageGroup, messageGroup, messageGroup, messageGroup,
                messageGroup, messageGroup, messageGroup, messageGroup,
                messageGroup, messageGroup, messageGroup, messageGroup,
                messageGroup, messageGroup, messageGroup, messageGroup,
                messageGroup, messageGroup, messageGroup, messageGroup
        );
    }
}
