package com.example.prueba;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ReportFragment extends Fragment {

    private EditText sensorParamEditText;
    private DatePicker datePicker;
    private Button generateReportButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report, container, false);

        sensorParamEditText = view.findViewById(R.id.sensor_param_edit_text);
        datePicker = view.findViewById(R.id.date_picker);
        generateReportButton = view.findViewById(R.id.generate_report_button);

        generateReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sensorParam = sensorParamEditText.getText().toString();
                int year = datePicker.getYear();
                int month = datePicker.getMonth();
                int day = datePicker.getDayOfMonth();

                // Aquí iría la lógica para generar el reporte
                generateReport(sensorParam, year, month, day);
            }
        });

        return view;
    }

    private void generateReport(String sensorParam, int year, int month, int day) {
        // Aquí iría la lógica para generar el reporte
        // Por ahora, solo mostramos un mensaje de confirmación
        sendToLCD("Generando reporte para el parámetro del sensor '" + sensorParam + "' y fecha " + day + "/" + (month+1) + "/" + year);

        // Implementar la generación real del reporte aquí
    }

    private void sendToLCD(String message) {
        // Aquí iría la lógica para enviar mensajes al LCD via WiFi
        // Por ahora, solo lo imprimimos en la consola
        Log.d("LCD", message);
    }
}
