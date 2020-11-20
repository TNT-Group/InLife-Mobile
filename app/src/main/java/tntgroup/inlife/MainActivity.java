package tntgroup.inlife;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import tntgroup.inlife.messenger.chat.MessengerChatFragment;

/**
 * Main activity class of application
 * (subclass of {@link AppCompatActivity})
 * with placeholder for fragments
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Navigate to BottomNavigationFragment for now
        final FragmentTransaction fragmentTransaction
                = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.activity_fragment_container,
//                BottomNavigationFragment.newInstance()
                MessengerChatFragment.newInstance("")
        );
        fragmentTransaction.commit();
    }
}
