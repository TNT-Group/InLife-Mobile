package tntgroup.inlife;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

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

    /**
     * Inflate the contents of messenger_toolbar_menu.xml into the toolbar
     */
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.messenger_toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_messenger, container, false);

        // Setup top app bar for current activity
        Toolbar toolbar = view.findViewById(R.id.messenger_toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
        }

        // Set listener for top app bar
        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                // "Search" was pressed
                case R.id.messenger_toolbar_search:
                    return true;
            }
            return false;
        });

        // Set data for list of message groups
        RecyclerView recyclerView = view.findViewById(R.id.messenger_list);
        MessageGroup messageGroup = new MessageGroup(
                0, "Haha!",
                false, "Tugushev Timur",
                R.drawable.ic_messenger_toolbar_search
        );
        MessengerAdapter adapter = new MessengerAdapter(view.getContext(), Arrays.asList(
                messageGroup, messageGroup, messageGroup, messageGroup
        ));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
