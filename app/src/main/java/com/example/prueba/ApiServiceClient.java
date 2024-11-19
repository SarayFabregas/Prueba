package com.example.prueba;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceClient {
    private static final String BASE_URL = "jdbc:mysql://b9kst8tszuwypisnkbrl-mysql.services.clever-cloud.com:3306/b9kst8tszuwypisnkbrl"; // Cambia esto a la URL de tu API
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL) // Establece la URL base de la API
                    .addConverterFactory(GsonConverterFactory.create()) // Agrega el convertidor Gson para manejar JSON
                    .build(); // Construye el objeto Retrofit
        }
        return retrofit; // Retorna la instancia de Retrofit
    }
}