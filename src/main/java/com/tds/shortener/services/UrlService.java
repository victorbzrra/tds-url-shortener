package com.tds.shortener.services;

import com.tds.shortener.entities.Url;
import org.springframework.stereotype.Service;

@Service
public interface UrlService {
    public Url generateShortUrl(String url);
    public Url persistShortUrl(Url url);
    public Url getEncodedUrl(String url);
}
