package tntgroup.inlife;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A subclass of {@link Fragment}
 * "Messenger" window of application
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
        Bundle args = getArguments();
        if (args != null) {
            /* Save data from bundle into instance of the class here */
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_messenger, container, false);
    }
}
