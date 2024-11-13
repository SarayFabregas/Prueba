package com.example.prueba.package.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.prueba.ApiService;
import com.example.prueba.ApiServiceClient;
import com.example.prueba.model.ApiResponse;


import retrofit2.Call;package.model.ApiResponse;

public class ControlFragment extends Fragment {

    private TextView sensorStatusTextView;
    private TextView motorStatusTextView;
    private TextView ledStatusTextView;
    private Button updateStatusButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_control, container, false);

        sensorStatusTextView = view.findViewById(R.id.sensor_status);
        motorStatusTextView = view.findViewById(R.id.motor_status);
        ledStatusTextView = view.findViewById(R.id.led_status);
        updateStatusButton = view.findViewById(R.id.update_status_button);

        updateStatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSensorStatus();
            }
        });

        return view;
    }

    private void updateSensorStatus() {
        ApiService apiService = ApiServiceClient.getClient().create(ApiService.class);
        Call<ApiResponse> call = apiService.updateStatus(1, "Activo");
        call.enqueue(new retrofit2.Callback<ApiResponse>() {
            @Override
            public void onResponse(retrofit2.Call<ApiResponse> call, retrofit2.Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    ApiResponse result = response.body();
                    // Procesar la respuesta y actualizar los estados
                    sensorStatusTextView.setText("Sensor: Activo");
                    motorStatusTextView.setText("Motor: Detenido");
                    ledStatusTextView.setText("LED: Apagado");
                } else {
                    // Manejar error de red o servidor
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ApiResponse> call, Throwable t) {
                // Manejar error de red o conexión
            }
        });
    }
}
