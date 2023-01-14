package com.tds.shortener.services;

import com.google.common.hash.Hashing;
import com.tds.shortener.entities.Url;
import com.tds.shortener.repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class UrlServiceImpl implements UrlService {
    private final UrlRepository urlRepository;

    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public Url generateShortUrl(String url) {
        if(!url.isEmpty()) {
            Url urlToPersist = new Url();
            urlToPersist.setOriginalUrl(url);
            urlToPersist.setShortUrl(encodeUrl(url).substring(0,6));

            return urlRepository.save(urlToPersist);
        }

        return null;
    }

    public String encodeUrl(String url) {
        LocalDateTime timeStamp = LocalDateTime.now();
        return Hashing.sha256()
                .hashString(url.concat(timeStamp.toString()), StandardCharsets.UTF_8).toString();
    }

    @Override
    public Url getEncodedUrl(String url) {
        return urlRepository.findByShortUrl(url);
    }
}
