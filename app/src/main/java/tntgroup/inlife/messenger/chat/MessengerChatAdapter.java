package tntgroup.inlife.messenger.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tntgroup.inlife.R;

public class MessengerChatAdapter
        extends RecyclerView.Adapter<MessengerChatAdapter.MessageViewHolder> {

    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;

    private final List<Message> messages;

    public MessengerChatAdapter(List<Message> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                viewType == VIEW_TYPE_MESSAGE_SENT
                        ? R.layout.message_layout_sent
                        : R.layout.message_layout_received,
                parent, false
        );
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = messages.get(position);
        holder.bind(message);
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messages.get(position);
        return message.isReceived() ? VIEW_TYPE_MESSAGE_RECEIVED : VIEW_TYPE_MESSAGE_SENT;
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {
        protected final TextView text, sendingTime;

        public MessageViewHolder(@NonNull View itemView) {
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
