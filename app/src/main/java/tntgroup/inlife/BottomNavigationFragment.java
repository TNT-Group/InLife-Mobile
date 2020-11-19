package tntgroup.inlife;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    @SuppressLint("NonConstantResourceId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(
                R.layout.fragment_bottom_navigation,
                container, false);
        // Instance of bottom navigation view
        final BottomNavigationView bottomNavigationView
                = view.findViewById(R.id.bottom_navigation_bar);

        // Set listener for bottom navigation bar
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            // Get activity attached to this fragment
            final AppCompatActivity activity = (AppCompatActivity) getActivity();
            if (activity != null) {
                // Get instances of FragmentManager of this activity
                final FragmentManager fragmentManager = activity.getSupportFragmentManager();
                // Get instance of transaction that was just begun
                final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Do tasks if one of navigation items was selected
                final Fragment previousFragment = fragmentManager.findFragmentById(
                        R.id.bottom_navigation_fragment_container);
                switch (item.getItemId()) {
                    case R.id.navigation_love:
                    case R.id.navigation_search:
                    case R.id.navigation_settings:
                        // Temporarily remove fragment from the container
                        if (previousFragment != null) {
                            fragmentTransaction.remove(previousFragment);
                        }
                        break;
                    case R.id.navigation_messenger:
                        // "Messenger" was selected
                        if (previousFragment instanceof MessengerFragment) {
                            break;
                        }
                        fragmentTransaction.replace(
                                R.id.bottom_navigation_fragment_container,
                                MessengerFragment.newInstance()
                        );
                        break;
                    default:
                        // If none of items was not selected
                        fragmentTransaction.commit();
                        return false;
                }
                fragmentTransaction.commit();
                return true;
            }
            return false;
        });
        return view;
    }
}
