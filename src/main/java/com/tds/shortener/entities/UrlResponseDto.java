package com.tds.shortener.entities;

public class UrlResponseDto {
    private String originalUrl;
    private String shortUrl;
    private String access;

    public UrlResponseDto(String originalUrl, String shortUrl, String access) {
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.access = access;
    }

    public UrlResponseDto() {

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

    public String getAccess() { return access; }

    public void setAccess(String access) { this.access = access; }

    @Override
    public String toString() {
        return "UrlResponseDto{" +
                "originalUrl='" + originalUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", access='" + access + '\'' +
                '}';
    }
}
