package com.example.prueba;
import com.example.prueba.model.ApiResponse;
import com.example.prueba.model.SensorData;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    // Método para iniciar sesión
    @POST("https://app-9afc6e0e-91ae-4750-8774-0a5f66365117.cleverapps.io/api/v1/public/login")
    Call<ApiResponse> login(@Query("username") String username, @Query("password") String password);

    // Método para obtener todos los registros de inicio de sesión
    @GET("https://app-9afc6e0e-91ae-4750-8774-0a5f66365117.cleverapps.io/api/v1/registrosInicioSesion")
    Call<List<ApiResponse>> getAllInicios();

    // Método para obtener usuario por ID
    @GET("https://app-9afc6e0e-91ae-4750-8774-0a5f66365117.cleverapps.io/api/v1/usuarios/idUsuario")
    Call<ApiResponse> getUsuarioById(@Path("idUsuario") int idUsuario);

    // Método para validar usuario
    @GET("https://app-9afc6e0e-91ae-4750-8774-0a5f66365117.cleverapps.io/api/v1/usuarios/validarUsuario")
    Call<ApiResponse> validarUsuario(@Query("nombreUsuario") String nombreUsuario, @Query("contraseña") String contrasena);

    // Método para guardar o actualizar usuario
    @POST("https://app-9afc6e0e-91ae-4750-8774-0a5f66365117.cleverapps.io/api/v1/usuarios/guardar")
    Call<ApiResponse> guardarUsuario(@Body ApiResponse usuario);

    // Método para eliminar usuario
    @DELETE("https://app-9afc6e0e-91ae-4750-8774-0a5f66365117.cleverapps.io/api/v1/usuarios/idUsuario")
    Call<ApiResponse> eliminarUsuario(@Path("idUsuario") int idUsuario);

    // Método para obtener todos los registros de comunicación
    @GET("https://app-9afc6e0e-91ae-4750-8774-0a5f66365117.cleverapps.io/api/v1/registrosComunicacion")
    Call<List<ApiResponse>> getAllRegistrosComunicacion();

    // Método para actualizar comunicación
    @PUT("https://app-9afc6e0e-91ae-4750-8774-0a5f66365117.cleverapps.io/api/v1/registrosComunicacion/actualizarComunicacion")
    Call<ApiResponse> actualizarComunicacion(@Body ApiResponse comunicacion);

    // Método para obtener todos los registros de sensores
    @GET("https://app-9afc6e0e-91ae-4750-8774-0a5f66365117.cleverapps.io/api/v1/registrosSensor")
    Call<List<SensorData>> getAllRegistrosSensor();

    // Método para registrar valor del sensor
    @PUT("https://app-9afc6e0e-91ae-4750-8774-0a5f66365117.cleverapps.io/api/v1/registrosSensor/registrarValorSensor")
    Call<ApiResponse> registrarValorSensor(@Body SensorData sensorData);

    // Método para obtener los últimos 5 registros de sensores
    @GET("https://app-9afc6e0e-91ae-4750-8774-0a5f66365117.cleverapps.io/api/v1/registrosSensor/ultimos5")
    Call<List<SensorData>> getUltimos5RegistrosSensor();

    // Método para obtener todos los registros de LED
    @GET("https://app-9afc6e0e-91ae-4750-8774-0a5f66365117.cleverapps.io/api/v1/registrosLed")
    Call<List<ApiResponse>> getAllRegistrosLed();

    // Método para registrar valor del LED
    @PUT("https://app-9afc6e0e-91ae-4750-8774-0a5f66365117.cleverapps.io/api/v1/registrosLed/registrarValorLed")
    Call<ApiResponse> registrarValorLed(@Body ApiResponse ledData);

    // Método para obtener el último registro de LED
    @GET("https://app-9afc6e0e-91ae-4750-8774-0a5f66365117.cleverapps.io/api/v1/registrosLed/ultimo")
    Call<ApiResponse> getUltimoRegistroLed();

    // Método para obtener los últimos 5 registros de LED
    @GET("https://app-9afc6e0e-91ae-4750-8774-0a5f66365117.cleverapps.io/api/v1/registrosLed/ultimos5")
    Call<List<ApiResponse>> getUltimos5RegistrosLed();

    Call<List<SensorData>> getSensorData(String sensorParam, String date);
}
