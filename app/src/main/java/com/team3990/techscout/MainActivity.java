package com.team3990.techscout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    /** Activity's lifecycle */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get an instance of the Nav Controller
        final NavController navController = Navigation.findNavController(this, R.id.activity_main_navHostFragment);
        final Set<Integer> topLevelDestinations = new HashSet<>(Arrays.asList(R.id.menu_item_game_scouting, R.id.menu_item_pit_scouting, R.id.menu_item_data_sheet));

        // Get an instance of the the bottom navigation view and the app bar configuration
        final BottomNavigationView bottomNavigationView = findViewById(R.id.activity_main_bottomNavigationView);
        final AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(topLevelDestinations).build();

        // Setup the Bottom Navigation View and the Action Bar
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // Remove the action bar's elevation
        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
        }
    }

}
