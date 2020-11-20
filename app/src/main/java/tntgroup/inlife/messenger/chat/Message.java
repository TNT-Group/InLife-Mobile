package tntgroup.inlife.messenger.chat;

public class Message {
    private final String text;
    private final String sendingTime;
    private final boolean received;

    public Message(String text, String sendingTime, boolean received) {
        this.text = text;
        this.sendingTime = sendingTime;
        this.received = received;
    }

    public String getSendingTime() {
        return sendingTime;
    }

    public String getText() {
        return text;
    }

    public boolean isReceived() {
        return received;
    }
}
