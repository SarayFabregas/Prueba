
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available
  package com.prueba.package;

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
  }


