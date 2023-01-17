package com.tds.shortener.entities;

public class UrlResDto {
    private String orignalUrl;
    private String shortUrl;

    public UrlResDto(String orignalUrl, String shortUrl) {
        this.orignalUrl = orignalUrl;
        this.shortUrl = shortUrl;
    }

    public UrlResDto() {
    }

    public static UrlResDto urlToUrlResDto(Url url) {
        return new UrlResDto(url.getOriginalUrl(), url.getShortUrl());
    }

    public String getOrignalUrl() {
        return orignalUrl;
    }

    public void setOrignalUrl(String orignalUrl) {
        this.orignalUrl = orignalUrl;
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
                "orignalUrl='" + orignalUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                '}';
    }
}

