package com.example.prueba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class PrincipalActivity extends AppCompatActivity {

    // Declarar el navListener como campo de la clase principal
    private BottomNavigationView.OnItemSelectedListener navListener =
            new NavigationBarView.OnItemSelectedListener() {
                @SuppressLint("NonConstantResourceId")
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    int itemId = item.getItemId();

                    if (itemId == R.id.nav_control) {
                        selectedFragment = new ControlFragment();
                    } else if (itemId == R.id.nav_report) {
                        selectedFragment = new ReportFragment();
                    } else if (itemId == R.id.nav_about) {
                        selectedFragment = new AboutFragment();
                    }

                    if (selectedFragment != null) {
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container, selectedFragment)
                                .commit();
                    }
                    return true;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(navListener);

        // Opcionalmente, establecer el fragmento inicial
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new ControlFragment())
                    .commit();
        }
    }

    private void sendToLCD(String message) {
        // Aquí iría la lógica para enviar mensajes al LCD via WiFi
        // Por ahora, solo lo imprimimos en la consola
        Log.d("LCD", message);
    }
}