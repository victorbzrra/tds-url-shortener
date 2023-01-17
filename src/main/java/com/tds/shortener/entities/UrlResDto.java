package com.tds.shortener.entities;

public class UrlResDto {
    private String originalUrl;
    private String shortUrl;

    public UrlResDto(String originalUrl, String shortUrl) {
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
    }

    public UrlResDto() {
    }

    public static UrlResDto urlToUrlResDto(Url url) {
        return new UrlResDto(url.getOriginalUrl(), url.getShortUrl());
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public String toString() {
        return "UrlResDto{" +
                "orignalUrl='" + originalUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                '}';
    }
}

