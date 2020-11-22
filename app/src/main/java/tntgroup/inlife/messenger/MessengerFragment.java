package tntgroup.inlife.messenger;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import tntgroup.inlife.R;

/**
 * A {@link Fragment} subclass which represents
 * "Messenger" window of application
 *
 * This fragment must have bottom navigation bar,
 * so it is located inside of bottom_navigation_fragment_container
 */
public class MessengerFragment extends Fragment {

    /* Define parameters and their keys here */

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters
     *
     * @return A new instance of {@link MessengerFragment}
     */
    public static MessengerFragment newInstance(/* Parameters are defined here */) {
        MessengerFragment fragment = new MessengerFragment();
        Bundle args = new Bundle();
        /* Put parameters into args Bundle object here */
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Bundle args = getArguments();
        if (args != null) {
            /* Save data from bundle into instance of the class here */
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_messenger, container, false);

        // Setup fragment elements
        setupToolbar(view);
        setupMessageGroupList(view);

        return view;
    }

    /**
     * Method for setting up a top app bar of fragment
     *
     * @param view inflated view in method {@link MessengerFragment#onCreateView}
     */
    private void setupToolbar(View view) {
        final Toolbar toolbar = view.findViewById(R.id.messenger_toolbar);
        // Set listener for top app bar
        toolbar.setOnMenuItemClickListener(this::onTopToolbarItemClick);
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
            case R.id.messenger_toolbar_search:
                return true;
        }
        return false;
    }

    /**
     * Method for setting up a list of message groups
     *
     * @param view inflated view in method {@link MessengerFragment#onCreateView}
     */
    private void setupMessageGroupList(View view) {
        final RecyclerView recyclerView = view.findViewById(R.id.messenger_list);
        final MessengerAdapter adapter = new MessengerAdapter(
                view.getContext(), getMessageGroups()
        );
        recyclerView.setAdapter(adapter);
    }

    /**
     * Get message groups for {@link MessengerFragment}'s
     * list (which is {@link androidx.recyclerview.widget.RecyclerView})
     * for current user
     *
     * @return list of message groups
     */
    public List<MessageGroup> getMessageGroups() {
        MessageGroup messageGroup = new MessageGroup(
                0, "Hello World!",
                false, "Surname Name",
                R.drawable.ic_navigation_love
        );
        return Arrays.asList(
                messageGroup, messageGroup, messageGroup, messageGroup,
                messageGroup, messageGroup, messageGroup, messageGroup,
                messageGroup, messageGroup, messageGroup, messageGroup,
                messageGroup, messageGroup, messageGroup, messageGroup,
                messageGroup, messageGroup, messageGroup, messageGroup
        );
    }
}
