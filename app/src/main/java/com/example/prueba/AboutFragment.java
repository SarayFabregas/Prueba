package com.example.prueba;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AboutFragment extends Fragment {

    private TextView aboutTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        aboutTextView = view.findViewById(R.id.about_text_view);

        // Configurar el texto con información sobre la aplicación
        aboutTextView.setText("Esta es una aplicación para controlar y monitorear sensores de obstáculos.\n\nVersión: 1.0\n\nDesarrollado por: Tu nombre");

        return view;
    }
}

