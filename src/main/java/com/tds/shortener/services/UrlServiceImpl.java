package com.tds.shortener.services;

import com.google.common.hash.Hashing;
import com.tds.shortener.entities.Url;
import com.tds.shortener.exceptions.BadRequest;
import com.tds.shortener.exceptions.NotFound;
import com.tds.shortener.repositories.UrlRepository;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Service
public class UrlServiceImpl implements UrlService {
    private final UrlRepository urlRepository;

    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public Url generateShortUrl(String url) {
        if(url.isEmpty()) {
           throw new BadRequest("Invalid url, try again!");
        }

        return urlRepository.save(toUrl(url));
    }

    private Url toUrl(String url) {
        Url urlToPersist = new Url();
        urlToPersist.setOriginalUrl(url);
        urlToPersist.setShortUrl(encodeUrl(url));
        return urlToPersist;
    }

    private String encodeUrl(String url) {
        LocalDateTime timeStamp = LocalDateTime.now();
        return Hashing.sha256()
                .hashString(url.concat(timeStamp.toString()), StandardCharsets.UTF_8).toString().substring(0,6);
    }

    @Override
    public String getEncodedUrl(String url) {
        Url urlToRes = urlRepository.findByShortUrl(url)
                .orElseThrow(() -> new NotFound("Url not found, try again!"));

        return saveNewAccess(urlToRes).getOriginalUrl();
    }

    private Url saveNewAccess(Url url) {
        url.setAccess(url.getAccess() + 1);
        return urlRepository.save(url);
    }
}
