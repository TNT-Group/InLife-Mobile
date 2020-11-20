package tntgroup.inlife.messenger.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tntgroup.inlife.R;

public class MessengerChatAdapter extends RecyclerView.Adapter<MessengerChatAdapter.ViewHolder> {

    private List<Message> messages;

    public MessengerChatAdapter(List<Message> dataSet) {
        this.messages = dataSet;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView text;
        private final TextView sendingTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.message_text);
            sendingTime = itemView.findViewById(R.id.message_sending_time);
        }

        public TextView getSendingTime() {
            return sendingTime;
        }

        public TextView getText() {
            return text;
        }
    }

    @NonNull
    @Override
    public MessengerChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(@NonNull MessengerChatAdapter.ViewHolder holder, int position) {
        Message message = messages.get(position);
        if (message.isMine()) {
            holder.getText().setGravity(Gravity.END);
            holder.getSendingTime().setGravity(Gravity.END);
        }
        else {
            holder.getText().setGravity(Gravity.START);
            holder.getSendingTime().setGravity(Gravity.START);
        }

        String text = message.getText() + " " + message.isMine();
        holder.getText().setText(text);
        holder.getSendingTime().setText(message.getSendingTime());

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
