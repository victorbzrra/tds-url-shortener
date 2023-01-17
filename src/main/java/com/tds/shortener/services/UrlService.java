package com.tds.shortener.services;

import com.tds.shortener.entities.Url;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UrlService {
    Url generateShortUrl(String url);
    String getEncodedUrl(String url);
    List<Url> getAllAccess();
    Integer getAccessByShortUrl(String shortUrl);
}