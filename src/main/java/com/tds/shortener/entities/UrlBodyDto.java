package com.tds.shortener.entities;

public class UrlBodyDto {
    private String url;

    public UrlBodyDto(String url) {
        this.url = url;
    }

    public UrlBodyDto() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UrlBodyDto{" +
                "url='" + url + '\'' +
                '}';
    }
}
