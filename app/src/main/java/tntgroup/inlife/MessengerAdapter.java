package tntgroup.inlife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Class of adapter for RecyclerView object in "Messenger" message group list
 *
 * The {@link RecyclerView} requests those views, and binds the views
 * to their data by helper class, derived from {@link RecyclerView.Adapter}
 */
public class MessengerAdapter extends RecyclerView.Adapter<MessengerAdapter.ViewHolder> {

    private final List<MessageGroup> groups;
    private final LayoutInflater inflater;

    public MessengerAdapter(Context context, List<MessageGroup> groups) {
        this.groups = groups;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(
                R.layout.messenger_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MessageGroup messageGroup = groups.get(position);
        holder.getUserName().setText(messageGroup.getUserName());
        holder.getLastMessage().setText(messageGroup.getLastMessage());
        holder.getUserAvatar().setImageResource(messageGroup.getUserAvatar());
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }

    /**
     * Each individual element in the {@link RecyclerView}
     * is defined by object of this class
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView userAvatar;
        private final TextView userName;
        private final TextView lastMessage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userAvatar = itemView.findViewById(R.id.messenger_item_user_avatar);
            userName = itemView.findViewById(R.id.messenger_item_user_name);
            lastMessage = itemView.findViewById(R.id.messenger_item_last_message);
        }

        public TextView getUserName() {
            return userName;
        }

        public TextView getLastMessage() {
            return lastMessage;
        }

        public ImageView getUserAvatar() {
            return userAvatar;
        }
    }
}
