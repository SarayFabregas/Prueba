package com.example.prueba;

import com.example.prueba.model.ApiResponse;
import com.example.prueba.model.SensorData;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ApiService {
    @GET("endpoints")
    Call<ApiResponse> getEndpoints();

    @POST("login")
    Call<ApiResponse> login(@Query("username") String username, @Query("password") String password);

    @PUT("update_status")
    Call<ApiResponse> updateStatus(@Query("sensor_id") int sensorId, @Query("status") String status);

    // Nuevo método para obtener los datos del sensor
    @GET("get_sensor_data") // Cambia esta URL por la que corresponda en tu API
    Call<List<SensorData>> getSensorData(@Query("sensorParam") String sensorParam, @Query("date") String date);

}
