package tntgroup.inlife.messenger.chat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

import tntgroup.inlife.R;

/**
 * A {@link Fragment} subclass for messenger chat
 */
public class MessengerChatFragment extends Fragment {

    /**
     * Key to get userId parameter
     * of fragment from the {@link Bundle}
     */
    private static final String USER_ID_KEY = "userId";

    /**
     * ID of user you are chatting with
     */
    private String userId;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of {@link MessengerChatFragment}
     */
    public static MessengerChatFragment newInstance(String userId) {
        MessengerChatFragment fragment = new MessengerChatFragment();
        Bundle args = new Bundle();
        args.putString(USER_ID_KEY, userId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            // Save data from bundle into instance of the class
            userId = args.getString(USER_ID_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_messenger_chat, container, false);

        // Setup fragment elements
        setupToolbar(view);
        setupMessageList(view);

        // Setup listeners for bottom bar buttons
        Button additions = view.findViewById(R.id.messenger_chat_bottom_panel_additions),
                emojis = view.findViewById(R.id.messenger_chat_bottom_panel_emojis),
                voice = view.findViewById(R.id.messenger_chat_bottom_panel_voice);
        additions.setOnClickListener(this::onAdditionsClick);
        emojis.setOnClickListener(this::onEmojisClick);
        voice.setOnClickListener(this::onVoiceClick);

        return view;
    }

    /**
     * Method for additions click event
     */
    private void onAdditionsClick(View view) {}

    /**
     * Method for emojis click event
     */
    private void onEmojisClick(View view) {}

    /**
     * Method for voice input click event
     */
    private void onVoiceClick(View view) {}

    /**
     * Method for setting up a top app bar of fragment
     *
     * @param view inflated view in method {@link MessengerChatFragment#onCreateView}
     */
    private void setupToolbar(View view) {
        final Toolbar toolbar = view.findViewById(R.id.messenger_chat_toolbar);

        // Set menu item listener for top app bar
        toolbar.setOnMenuItemClickListener(this::onTopToolbarItemClick);

        // Set navigation icon listener for top app bar
        // (actually, implement "back" behaviour of navigation icon)
        final AppCompatActivity activity = (AppCompatActivity) getActivity();
        toolbar.setNavigationOnClickListener(v -> {
            if (activity != null) {
                activity.onBackPressed();
            }
        });
    }

    /**
     * Listener for top toolbar items
     *
     * @param item item that was pressed
     * @return if any item was pressed
     */
    @SuppressLint("NonConstantResourceId")
    private boolean onTopToolbarItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.messenger_chat_toolbar_search:
            case R.id.messenger_chat_toolbar_overflow_menu:
                return true;
        }
        return false;
    }

    /**
     * Method for setting up a message list
     *
     * @param view inflated view in method {@link MessengerChatFragment#onCreateView}
     */
    private void setupMessageList(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.messages_list);
        MessengerChatAdapter adapter = new MessengerChatAdapter(getMessageList());
        recyclerView.setAdapter(adapter);
    }

    private List<Message> getMessageList() {
        List<Message> messageList = new LinkedList<>();
        String text1 = "RecyclerView makes it easy to efficiently " +
                "display large sets of data. You supply the data and" +
                " define how each item looks, and the RecyclerView library" +
                " dynamically creates the elements when they're needed.\n" +
                "\n" +
                "As the name implies, RecyclerView recycles those individual " +
                "elements. When an item scrolls off the screen, RecyclerView doesn't" +
                " destroy its view. Instead, RecyclerView reuses the view for new items" +
                " that have scrolled onscreen. This reuse vastly improves performance, " +
                "improving your app's responsiveness and reducing power consumption. ";
        for (int i = 1; i < 21; i++) {
            messageList.add(new Message(text1, "00:00", i % 2 == 0));
        }
        return messageList;
    }
}
