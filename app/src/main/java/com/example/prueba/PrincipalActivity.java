package com.example.prueba;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import androidx.fragment.app.Fragment; // Cambio importante aquí
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener el nombre de usuario de la actividad anterior
        String username = getIntent().getStringExtra("username");

        // Mostrar el nombre de usuario en el LCD
        sendToLCD(username + " inició sesión");

        // Configurar el menú de navegación
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        bottomNav.setSelectedItemId(R.id.nav_control); // Establecer el elemento seleccionado inicialmente
        bottomNav.inflateMenu(R.menu.bottom_navigation_menu);

        // Cargar el fragmento inicial
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new ControlFragment())
                .commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_control:
                            selectedFragment = new ControlFragment();
                            break;
                        case R.id.nav_report:
                            selectedFragment = new ReportFragment();
                            break;
                        case R.id.nav_about:
                            selectedFragment = new AboutFragment();
                            break;
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



    private void sendToLCD(String message) {
        // Aquí iría la lógica para enviar mensajes al LCD via WiFi
        // Por ahora, solo lo imprimimos en la consola
        Log.d("LCD", message);
    }
}