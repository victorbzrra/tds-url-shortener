package com.tds.shortener.repositories;

import com.tds.shortener.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url,Long> {
    Url findByShortUrl(String shortUrl);

}
