package com.tds.shortener.repositories;

import com.tds.shortener.entities.Url;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("Tests for Url Repository")
class UrlRepositoryTest {
    @Autowired
    private UrlRepository urlRepository;

    @Test
    @DisplayName("Save persists url when Successful")
    void save_PersistUrl_WhenSuccessful() {
        Url urlToBeSave = createUrl();
        Url urlSaved = this.urlRepository.save(urlToBeSave);

        Assertions.assertThat(urlSaved).isNotNull();
        Assertions.assertThat(urlSaved.getId()).isNotNull();
        Assertions.assertThat(urlSaved.getOriginalUrl()).isEqualTo(urlToBeSave.getOriginalUrl());
        Assertions.assertThat(urlSaved.getShortUrl()).isEqualTo(urlToBeSave.getShortUrl());
        Assertions.assertThat(urlSaved.getAccess()).isEqualTo(0);
    }

    @Test
    @DisplayName("Save update access url when Successful")
    void save_UpdatesAccessUrl_WhenSuccessful() {
        Url urlToBeSave = createUrl();
        Url urlSaved = this.urlRepository.save(urlToBeSave);

        urlSaved.setAccess(urlSaved.getAccess() + 1);
        Url urlUpdated = this.urlRepository.save(urlSaved);

        Assertions.assertThat(urlUpdated).isNotNull();
        Assertions.assertThat(urlUpdated.getId()).isNotNull();
        Assertions.assertThat(urlUpdated.getOriginalUrl()).isEqualTo(urlSaved.getOriginalUrl());
        Assertions.assertThat(urlUpdated.getShortUrl()).isEqualTo(urlSaved.getShortUrl());
        Assertions.assertThat(urlUpdated.getAccess()).isEqualTo(1);
    }

    @Test
    @DisplayName("Find by shortUrl return originalUrl when Successful")
    void findByShortUrl_ReturnOriginalUrl_WhenSuccessful() {
        Url urlToBeSave = createUrl();
        Url urlSaved = this.urlRepository.save(urlToBeSave);

        String shortUrl = urlSaved.getShortUrl();
        Url byShortUrl = this.urlRepository.findByShortUrl(shortUrl);

        Assertions.assertThat(byShortUrl).isNotNull();
        Assertions.assertThat(byShortUrl.getId()).isNotNull();
        Assertions.assertThat(byShortUrl.getShortUrl()).isEqualTo(urlSaved.getShortUrl());
    }

    @Test
    @DisplayName("Find by shortUrl return null when no url is found")
    void findByShortUrl_ReturnNull_WhenUrlIsNotFound() {
        String shortUrl = "659f494";
        Url byShortUrl = this.urlRepository.findByShortUrl(shortUrl);

        Assertions.assertThat(byShortUrl).isNull();
    }

    private Url createUrl() {
        Url url = new Url();
        url.setOriginalUrl("https://www.amazon.com.br/");
        url.setShortUrl("814ad4");
        return url;
    }
}