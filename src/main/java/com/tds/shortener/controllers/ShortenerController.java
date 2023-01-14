package com.tds.shortener.controllers;

import com.tds.shortener.entities.Url;
import com.tds.shortener.services.UrlService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.http.HttpStatus.MOVED_PERMANENTLY;

@RestController
public class ShortenerController {
    private final UrlService urlService;

    public ShortenerController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public Url generateShortUrl(@RequestBody String url) {
        return urlService.generateShortUrl(url);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortUrl) throws URISyntaxException {
        String urlToRes = urlService.getEncodedUrl(shortUrl);

        URI uri = new URI(urlToRes);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);

        return new ResponseEntity<>(httpHeaders, MOVED_PERMANENTLY);
    }
}
