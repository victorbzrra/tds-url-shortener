package com.tds.shortener.entities;

public class UrlErrorResDto {
    private String status;
    private String error;

    public UrlErrorResDto(String status, String error) {
        this.status = status;
        this.error = error;
    }

    public UrlErrorResDto() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "UrlErrorResDto{" +
                "status='" + status + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
