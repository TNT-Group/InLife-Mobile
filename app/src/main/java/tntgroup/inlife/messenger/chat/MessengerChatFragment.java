package tntgroup.inlife.messenger.chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import tntgroup.inlife.R;

/**
 * A {@link Fragment} subclass for messenger chat
 */
public class MessengerChatFragment extends Fragment {

    private static final String USER_ID_KEY = "userId";

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
        return inflater.inflate(R.layout.fragment_messenger_chat, container, false);
    }

    /**
     * A lass for bottom panel in messenger chat
     */
    private class BottomPanel {
        private Button smile;
        private Button additions;
        private Button voice;

        private EditText message;

        BottomPanel(View rootView)
        {
            smile = rootView.findViewById(R.id.smile);
            smile.setOnClickListener(v -> onSmileClick());
            additions = rootView.findViewById(R.id.additions);
            additions.setOnClickListener(v -> onAdditionsClick());
            voice = rootView.findViewById(R.id.voice);
            voice.setOnClickListener(v -> onVoiceClick());
            message = rootView.findViewById(R.id.message);
        }

        public void onSmileClick()
        {}
        public void onAdditionsClick()
        {}
        public void onVoiceClick()
        {}


    }
}
