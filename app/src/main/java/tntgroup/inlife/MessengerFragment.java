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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_messenger, container, false);

        // Get current activity
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        setupToolbar(view, activity);
        setupMessageGroupList(view);

        return view;
    }

    /**
     * Method for setting up a top app bar of fragment
     *
     * @param view inflated view in method {@link MessengerFragment#onCreateView}
     * @param activity current activity of fragment
     */
    @SuppressLint("NonConstantResourceId")
    private void setupToolbar(View view, AppCompatActivity activity) {
        Toolbar toolbar = view.findViewById(R.id.messenger_toolbar);
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
    }

    /**
     * Method for setting up a list of message groups
     *
     * @param view inflated view in method {@link MessengerFragment#onCreateView}
     */
    private void setupMessageGroupList(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.messenger_list);
        MessengerAdapter adapter = new MessengerAdapter(view.getContext(),
                Database.getInstance().getMessageGroups());
        recyclerView.setAdapter(adapter);
    }
}
