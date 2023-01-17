package com.tds.shortener.entities;

import java.util.ArrayList;
import java.util.List;

public class StatsDto {
    private String shortUrl;
    private Integer access;

    public StatsDto(String shortUrl, Integer access) {
        this.shortUrl = shortUrl;
        this.access = access;
    }

    public StatsDto() {
    }

    public static StatsDto urlToStatsDto(Url url) {
        return new StatsDto(url.getShortUrl(), url.getAccess());
    }

    public static List<StatsDto> urlListToStatusDTOList(List<Url> urlList) {
        List<StatsDto> statsList = new ArrayList<>();
        urlList.forEach(url -> statsList.add(urlToStatsDto(url)));

        return statsList;
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
        return "StatsDto{" +
                "shortUrl='" + shortUrl + '\'' +
                ", access=" + access +
                '}';
    }
}
