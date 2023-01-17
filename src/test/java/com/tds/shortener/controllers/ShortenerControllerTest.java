package com.tds.shortener.controllers;

import com.tds.shortener.entities.UrlBodyDto;
import com.tds.shortener.entities.UrlResDto;
import com.tds.shortener.exceptions.BadRequest;
import com.tds.shortener.services.UrlService;
import com.tds.shortener.utils.UrlCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ShortenerControllerTest {
    @InjectMocks
    private ShortenerController shortenerController;
    @Mock
    private UrlService urlServiceMock;

    @BeforeEach
    void setUp() {
        BDDMockito.when(urlServiceMock.generateShortUrl(ArgumentMatchers.anyString()))
                .thenReturn(UrlCreator.createUrl());

        BDDMockito.when(urlServiceMock.generateShortUrl("")).thenThrow(BadRequest.class);
    }

    @Test
    @DisplayName("Generate shortUrl returns UrlResDto when request sucessful")
    void generateShortUrl_ReturnUrlResDto_WhenSuccessful() {
        UrlBodyDto urlToBeSave = UrlCreator.urlBodyDto();
        UrlResDto urlToRes = shortenerController.generateShortUrl(urlToBeSave);

        Assertions.assertThat(urlToRes).isNotNull();
        Assertions.assertThat(urlToRes.getOriginalUrl()).isEqualTo(urlToBeSave.getUrl());
        Assertions.assertThat(urlToRes.getShortUrl()).isNotNull();
    }

    @Test
    @DisplayName("Generate shortUrl returns null when url is empty")
    void generateShortUrl_ReturnNull_WhenUrlIsEmpty() {
        UrlBodyDto urlToBeSave = UrlCreator.urlBodyDtoEmpty();

        Assertions.assertThatExceptionOfType(BadRequest.class)
                .isThrownBy(() -> shortenerController.generateShortUrl(urlToBeSave));
    }
}