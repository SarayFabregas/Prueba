package com.example.prueba;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.prueba.model.SensorData;
import com.example.prueba.ApiService;
import com.example.prueba.ApiServiceClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        String date = year + "-" + (month + 1) + "-" + day; // Formato de fecha

        ApiService apiService = ApiServiceClient.getClient().create(ApiService.class);
        Call<List<SensorData>> call = apiService.getSensorData(sensorParam, date);
        call.enqueue(new Callback<List<SensorData>>() {
            @Override
            public void onResponse(Call<List<SensorData>> call, Response<List<SensorData>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<SensorData> sensorDataList = response.body();
                    // Aquí puedes generar el archivo Excel o PDF con los datos obtenidos
                    createExcelReport(sensorDataList);
                } else {
                    // Manejar error
                    Log.e("ReportFragment", "Error en la respuesta de la API");
                }
            }

            @Override
            public void onFailure(Call<List<SensorData>> call, Throwable t) {
                // Manejar error de red o conexión
                Log.e("ReportFragment", "Error en la conexión a la API", t);
            }
        });
    }
    private void createExcelReport(List<SensorData> sensorDataList) {
        // Lógica para crear un archivo Excel con los datos
        // Puedes usar una librería como Apache POI o JExcelApi
    }
    private void sendToLCD(String message) {
        // Aquí iría la lógica para enviar mensajes al LCD via WiFi
        // Por ahora, solo lo imprimimos en la consola
        Log.d("LCD", message);
    }
}
