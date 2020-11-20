package tntgroup.inlife.messenger.chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import tntgroup.inlife.R;

/**
 * A {@link Fragment} subclass for messenger chat
 */
public class MessengerChatFragment extends Fragment {

    private static final String USER_ID_KEY = "userId";

    private String userId;
    private List<Message> messages = getMessageList();

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
        RecyclerView recyclerView = view.findViewById(R.id.messages_list);
        MessengerChatAdapter adapter = new MessengerChatAdapter(messages);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private List<Message> getMessageList() {
        List<Message> messageList = new ArrayList<>();
        String text1 = "RecyclerView makes it easy to efficiently " +
                "display large sets of data. You supply the data and" +
                " define how each item looks, and the RecyclerView library" +
                " dynamically creates the elements when they're needed.\n" +
                "\n" +
                "As the name implies, RecyclerView recycles those individual " +
                "elements. When an item scrolls off the screen, RecyclerView doesn't" +
                " destroy its view. Instead, RecyclerView reuses the view for new items" +
                " that have scrolled onscreen. This reuse vastly improves performance, " +
                "improving your app's responsiveness and reducing power consumption. ",
        text2 = "Sent message";
        for (int i = 1; i < 21; i++) {
            messageList.add(new Message(text1, "00:00", i % 2 == 0));
        }
        return messageList;
    }
}
