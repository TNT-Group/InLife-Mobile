package tntgroup.inlife.messenger.chat;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import tntgroup.inlife.R;
import tntgroup.inlife.messenger.MessengerFragment;

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
        View view = inflater.inflate(R.layout.fragment_messenger_chat, container, false);

        // Setup fragment elements
        setupToolbar(view);

        return view;
    }

    /**
     * Method for setting up a top app bar of fragment
     *
     * @param view inflated view in method {@link MessengerFragment#onCreateView}
     */
    @SuppressLint("NonConstantResourceId")
    private void setupToolbar(View view) {
        final AppCompatActivity activity = (AppCompatActivity) getActivity();
        final Toolbar toolbar = view.findViewById(R.id.messenger_chat_toolbar);
        if (activity != null) {
            final ActionBar actionBar = activity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayShowTitleEnabled(false);
            }
        }

        // Set menu item listener for top app bar
        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.messenger_chat_toolbar_search:
                    return true;
            }
            return false;
        });

        // Set navigation icon listener for top app bar
        // (actually, implement "back" behaviour of navigation icon)
        toolbar.setNavigationOnClickListener(v -> {
            if (activity != null) {
                activity.onBackPressed();
            }
        });
    }
}
