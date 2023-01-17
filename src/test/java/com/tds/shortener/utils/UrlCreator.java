package com.tds.shortener.utils;

import com.tds.shortener.entities.Url;
import com.tds.shortener.entities.UrlBodyDto;
import com.tds.shortener.entities.UrlResDto;

public class UrlCreator {
    public static Url createUrl() {
        Url url = new Url();
        url.setOriginalUrl("https://www.amazon.com.br/");
        url.setShortUrl("814ad4");
        return url;
    }

    public static UrlBodyDto urlBodyDto() {
        UrlBodyDto urlBodyDto = new UrlBodyDto();
        urlBodyDto.setUrl("https://www.amazon.com.br/");
        return urlBodyDto;
    }

    public static UrlBodyDto urlBodyDtoEmpty() {
        UrlBodyDto urlBodyDto = new UrlBodyDto();
        urlBodyDto.setUrl("");
        return urlBodyDto;
    }
}
