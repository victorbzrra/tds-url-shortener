package com.tds.shortener.controllers;

import com.tds.shortener.entities.StatsDto;
import com.tds.shortener.services.UrlService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/access")
public class StatisticsController {
    private final UrlService urlService;

    public StatisticsController(UrlService urlService) { this.urlService = urlService; }

    @GetMapping
    public List<StatsDto> getAllAccess() {
        return StatsDto.urlListToStatusDTOList(urlService.getAllAccess());
    }

    @GetMapping("/{shortUrl}")
    public Integer getAccessByShortUrl(@PathVariable String shortUrl) {
        return urlService.getAccessByShortUrl(shortUrl);
    }
}
