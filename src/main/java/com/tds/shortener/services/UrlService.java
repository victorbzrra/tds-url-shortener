package com.tds.shortener.services;

import com.tds.shortener.entities.Url;
import org.springframework.stereotype.Service;

@Service
public interface UrlService {
    Url generateShortUrl(String url);
    String getEncodedUrl(String url);
}