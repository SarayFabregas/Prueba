package com.example.prueba.model;
import com.google.gson.annotations.SerializedName;
public class ApiResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    public class ApiResponse {
        @SerializedName("status")
        private String status;

        @SerializedName("message")
        private String message;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }



}

