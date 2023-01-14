package com.tds.shortener.entities;

import jakarta.persistence.*;

@Entity
public class Url {
    @Id
    @GeneratedValue
    private long id;
    @Lob
    private String originalUrl;
    private String shortUrl;
    private Integer access;

    public Url(long id, String originalUrl, String shortUrl, Integer access) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.access = access;
    }

    public Url() {
        this.access = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", originalUrl='" + originalUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", access=" + access +
                '}';
    }
}
