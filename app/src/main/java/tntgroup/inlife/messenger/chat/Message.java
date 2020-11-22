package tntgroup.inlife.messenger.chat;

public class Message {
    private String text;
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

    public boolean isReceived() {
        return received;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
