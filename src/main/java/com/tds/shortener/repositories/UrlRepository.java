package com.tds.shortener.repositories;

import com.tds.shortener.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url,Long> {
    Optional<Url> findByShortUrl(String shortUrl);

}
