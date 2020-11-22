package tntgroup.inlife;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import tntgroup.inlife.messenger.MessengerFragment;

/**
 * A {@link Fragment} subclass which holds another fragments
 * that need {@link BottomNavigationView} at the bottom
 */
public class BottomNavigationFragment extends Fragment {

    /**
     * Instance on messenger fragment in container
     */
    private MessengerFragment messengerFragment;

    /**
     * Instance on current fragment in container
     */
    private Fragment currentFragment;

    /* Define parameters and their keys here */

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters
     *
     * @return A new instance of {@link BottomNavigationFragment}
     */
    public static BottomNavigationFragment newInstance(/* Parameters are defined here */) {
        BottomNavigationFragment fragment = new BottomNavigationFragment();
        Bundle args = new Bundle();
        /* Put parameters into args Bundle object here */
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            /* Save data from bundle into instance of the class here */
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_bottom_navigation,
                container, false);

        // Set listener for bottom navigation bar
        final BottomNavigationView bottomNavigationView
                = view.findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                this::onBottomNavigationBarItemSelected);

        return view;
    }

    /**
     * Listener for bottom navigation bar items
     *
     * @param item item that was pressed
     * @return if any item was pressed
     */
    @SuppressLint("NonConstantResourceId")
    private boolean onBottomNavigationBarItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_love:
                showLove();
                return true;
            case R.id.navigation_search:
                showSearch();
                return true;
            case R.id.navigation_settings:
                showSettings();
                return true;
            case R.id.navigation_messenger:
                showMessenger();
                return true;
        }
        return false;
    }

    /**
     * Method to show "Messenger" in container
     */
    private void showMessenger() {
        // Do not replace same fragment
        if (currentFragment instanceof MessengerFragment) {
            return;
        }

        final FragmentManager fragmentManager = getChildFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Create messenger fragment if needed
        if (messengerFragment == null) {
            messengerFragment = MessengerFragment.newInstance();
        }
        // Hide current fragment
        if (currentFragment != null) {
            fragmentTransaction.hide(currentFragment);
        }
        // Show messenger fragment
        if (!messengerFragment.isAdded()) {
            fragmentTransaction.add(
                    R.id.bottom_navigation_fragment_container,
                    messengerFragment
            );
        }
        fragmentTransaction.show(messengerFragment);

        currentFragment = messengerFragment;
        fragmentTransaction.commit();
    }

    /**
     * Method to show "Settings" in container
     */
    private void showSettings() {
        // todo
        // Hide current fragment
        if (currentFragment != null) {
            final FragmentManager fragmentManager = getChildFragmentManager();
            final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.hide(currentFragment);
            fragmentTransaction.commit();
        }
        currentFragment = null;
    }

    /**
     * Method to show "Love" in container
     */
    private void showLove() {
        // todo
        showSettings();
    }

    /**
     * Method to show "Search" in container
     */
    private void showSearch() {
        // todo
        showSettings();
    }
}
