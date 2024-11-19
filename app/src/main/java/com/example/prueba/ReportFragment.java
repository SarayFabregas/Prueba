package com.example.prueba;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.prueba.model.SensorData;
import com.example.prueba.ApiService;
import com.example.prueba.ApiServiceClient;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
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
                } else {
                    // Manejar error
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
        // Crear un libro de trabajo de Excel
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sensor Data");

        // Crear la fila de encabezados
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Parameter");
        headerRow.createCell(2).setCellValue("Value");
        headerRow.createCell(3).setCellValue("Timestamp");

        // Llenar los datos
        int rowNum = 1;
        for (SensorData sensorData : sensorDataList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(sensorData.getId());
            row.createCell(1).setCellValue(sensorData.getParameter());
            row.createCell(2).setCellValue(sensorData.getValue());
            row.createCell(3).setCellValue(sensorData.getTimestamp());
        }

        // Guardar el archivo Excel
        try {
            // Define la ruta donde se guardará el archivo Excel
            String filePath = Environment.getExternalStorageDirectory().getPath() + "/SensorDataReport.xlsx";
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            outputStream.close();
            workbook.close();

            // Notificar al usuario que el archivo se ha creado
            Log.d("ExcelReport", "Archivo Excel creado en: " + filePath);
            Toast.makeText(getContext(), "Reporte creado: " + filePath, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("ExcelReport", "Error al crear el archivo Excel", e);
            Toast.makeText(getContext(), "Error al crear el archivo Excel", Toast.LENGTH_SHORT).show();
        }
    }
    private void sendToLCD(String message) {
        // Aquí iría la lógica para enviar mensajes al LCD via WiFi
        // Por ahora, solo lo imprimimos en la consola
        Log.d("LCD", message);
    }
}
