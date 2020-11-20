package tntgroup.inlife.messenger.chat;

public class Message {
    private final String text;
    private final String sendingTime;
    private final boolean mine;

    public Message(String text, String sendingTime, boolean mine) {
        this.text = text;
        this.sendingTime = sendingTime;
        this.mine = mine;
    }

    public String getSendingTime() {
        return sendingTime;
    }

    public String getText() {
        return text;
    }

    public boolean isMine() {
        return mine;
    }
}
