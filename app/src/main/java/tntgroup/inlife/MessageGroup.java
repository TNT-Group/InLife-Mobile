package tntgroup.inlife;

/**
 * Class for holding data to show in messenger
 */
public class MessageGroup {

    private int unreadMessageCount;
    private String lastMessage;
    private boolean muted;

    private String userName;
    private int userAvatar;

    public MessageGroup(int unreadMessageCount, String lastMessage, boolean muted,
                        String userName, int userAvatar) {
        this.unreadMessageCount = unreadMessageCount;
        this.lastMessage = lastMessage;
        this.muted = muted;
        this.userName = userName;
        this.userAvatar = userAvatar;
    }

    public int getUnreadMessageCount() {
        return unreadMessageCount;
    }

    public void setUnreadMessageCount(int unreadMessageCount) {
        this.unreadMessageCount = unreadMessageCount;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(int userAvatar) {
        this.userAvatar = userAvatar;
    }
}
