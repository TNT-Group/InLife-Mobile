package tntgroup.inlife;

import androidx.appcompat.app.AppCompatActivity;

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
            switch (item.getItemId()) {
                // "Love" was selected
                case R.id.nav_love:
                    break;
                // "Search" was selected
                case R.id.nav_search:
                    break;
                // "Messenger" was selected
                case R.id.nav_messenger:
                    break;
                // "Settings" was selected
                case R.id.nav_settings:
                    break;
            }
            return true;
        });
    }
}
