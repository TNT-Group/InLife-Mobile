package tntgroup.inlife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Main activity class of application (subclass of {@link AppCompatActivity})
 * with bottom navigation bar {@link BottomNavigationView}
 */
public class MainActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instance of bottom navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        // Set listener for select action
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            clearFragmentContainer();
            switch (item.getItemId()) {
                // "Love" was selected
                case R.id.nav_love:
                    return true;
                // "Search" was selected
                case R.id.nav_search:
                    return true;
                // "Messenger" was selected
                case R.id.nav_messenger:
                    showMessenger();
                    return true;
                // "Settings" was selected
                case R.id.nav_settings:
                    return true;
            }
            return false;
        });
    }

    private void clearFragmentContainer() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (fragment != null) {
                fragmentTransaction.remove(fragment);
            }
        }
        fragmentTransaction.commit();
        setSupportActionBar(null);
    }

    private void showMessenger() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, MessengerFragment.newInstance());
        fragmentTransaction.commit();
    }
}
