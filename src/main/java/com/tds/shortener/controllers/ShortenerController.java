package com.tds.shortener.controllers;

import com.tds.shortener.entities.Url;
import com.tds.shortener.entities.UrlErrorResDto;
import com.tds.shortener.entities.UrlResponseDto;
import com.tds.shortener.services.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
public class ShortenerController {
    private final UrlService urlService;

    public ShortenerController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<?> generateShortUrl(@RequestBody String url) {
        Url urlToRes = urlService.generateShortUrl(url);

        if(Objects.nonNull(urlToRes)) {
            UrlResponseDto urlResponseDto = new UrlResponseDto();
            urlResponseDto.setOriginalUrl(urlToRes.getOriginalUrl());
            urlResponseDto.setShortUrl(urlToRes.getShortUrl());
            urlResponseDto.setAccess(urlToRes.getAccess().toString());

            return new ResponseEntity<UrlResponseDto>(urlResponseDto, HttpStatus.OK);
        }

        UrlErrorResDto urlErrorResDto = new UrlErrorResDto();
        urlErrorResDto.setStatus("404");
        urlErrorResDto.setError("Error occurred while processing the request, try again!");
        return new ResponseEntity<UrlErrorResDto>(urlErrorResDto, HttpStatus.OK);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortUrl) {
        if(shortUrl.isEmpty()) {
            UrlErrorResDto urlErrorResDto = new UrlErrorResDto();
            urlErrorResDto.setStatus("400");
            urlErrorResDto.setError("Invalid url, try again!");
            return new ResponseEntity<UrlErrorResDto>(urlErrorResDto, HttpStatus.OK);
        }

        Url urlToRes = urlService.getEncodedUrl(shortUrl);

        if(Objects.isNull(urlToRes)) {
            UrlErrorResDto urlErrorResDto = new UrlErrorResDto();
            urlErrorResDto.setStatus("400");
            urlErrorResDto.setError("Url does not exist, try again!");
            return new ResponseEntity<UrlErrorResDto>(urlErrorResDto, HttpStatus.OK);
        }


    }
}
