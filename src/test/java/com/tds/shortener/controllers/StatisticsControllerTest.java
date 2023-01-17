package com.tds.shortener.controllers;

import com.tds.shortener.entities.*;
import com.tds.shortener.services.UrlService;
import com.tds.shortener.utils.UrlCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class StatisticsControllerTest {
    @InjectMocks
    private StatisticsController statisticsController;

    @Mock
    private UrlService urlServiceMock;

    @BeforeEach
    void setUp() {
        BDDMockito.when(urlServiceMock.getAllAccess()).thenReturn(List.of(UrlCreator.createUrl()));
    }

    @Test
    @DisplayName("list of StatsDto returns all access when request sucessful")
    void list_ReturnAllAccess_WhenSuccessful() {
        Integer expectedAccess = UrlCreator.createUrl().getAccess();
        List<StatsDto> urlToRes = statisticsController.getAllAccess();

        Assertions.assertThat(urlToRes).isNotNull().isNotEmpty().hasSize(1);
        Assertions.assertThat(urlToRes.get(0).getAccess()).isEqualTo(expectedAccess);
    }

    @Test
    @DisplayName("Get Access by shortUrl returns access when request sucessful")
    void getAccessByShortUrl_ReturnAccess_WhenSuccessful() {
        Url urlToBeFind = UrlCreator.createUrl();
        AccessDto accessToRes = statisticsController.getAccessByShortUrl(urlToBeFind.getShortUrl());

        Assertions.assertThat(accessToRes).isNotNull();
        Assertions.assertThat(accessToRes.getTotalAccess()).isEqualTo(urlToBeFind.getAccess());
    }

    @Test
    @DisplayName("Get Access by shortUrl returns zero when no access is found")
    void getAccessByShortUrl_ReturnZero_WhenNoAccessIsFound() {
        String shortUrlToBeFind = "194f13";
        AccessDto accessToRes = statisticsController.getAccessByShortUrl(shortUrlToBeFind);

        Assertions.assertThat(accessToRes).isNotNull();
        Assertions.assertThat(accessToRes.getTotalAccess()).isEqualTo(0);
    }
}