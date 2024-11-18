package com.example.prueba.model;
import com.google.gson.annotations.SerializedName;
public class SensorData {
    @SerializedName("id") // Cambia esto según el nombre del campo en tu API
    private int id;

    @SerializedName("parameter") // Cambia esto según el nombre del campo en tu API
    private String parameter;

    @SerializedName("value") // Cambia esto según el nombre del campo en tu API
    private String value;

    @SerializedName("timestamp") // Cambia esto según el nombre del campo en tu API
    private String timestamp;

    // Constructor vacío
    public SensorData() {
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
