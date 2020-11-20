package tntgroup.inlife.messenger.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tntgroup.inlife.R;

public class MessengerChatAdapter extends RecyclerView.Adapter{

    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;

    private List<Message> messages;

    public MessengerChatAdapter(List<Message> dataSet) {
        this.messages = dataSet;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_MESSAGE_SENT) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.message_layout_sent, parent, false);
            return new SentMessageViewHolder(view);
        } else if (viewType == VIEW_TYPE_MESSAGE_RECEIVED) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.message_layout_received, parent, false);
            return new ReceivedMessageViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_MESSAGE_SENT:
                ((SentMessageViewHolder) holder).bind(messages.get(position));
                break;
            case VIEW_TYPE_MESSAGE_RECEIVED:
                ((ReceivedMessageViewHolder) holder).bind(messages.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messages.get(position);

        if (message.isReceived()) {
            // If the current user is the sender of the message
            return VIEW_TYPE_MESSAGE_RECEIVED;
        } else {
            // If some other user sent the message
            return VIEW_TYPE_MESSAGE_SENT;
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public static class SentMessageViewHolder extends RecyclerView.ViewHolder{
        private final TextView text, sendingTime;

        public SentMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            this.text = itemView.findViewById(R.id.message_text);
            this.sendingTime = itemView.findViewById(R.id.message_sending_time);
        }

        public void bind(Message message) {
            text.setText(message.getText());
            sendingTime.setText(message.getSendingTime());
        }
    }

    public static class ReceivedMessageViewHolder extends RecyclerView.ViewHolder{
        private final TextView text, sendingTime;

        public ReceivedMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            this.text = itemView.findViewById(R.id.message_text);
            this.sendingTime = itemView.findViewById(R.id.message_sending_time);
        }

        public void bind(Message message) {
            text.setText(message.getText());
            sendingTime.setText(message.getSendingTime());
        }
    }
}
