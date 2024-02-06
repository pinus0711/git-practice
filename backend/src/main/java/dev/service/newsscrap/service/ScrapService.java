package dev.service.newsscrap.service;

import dev.service.newsscrap.dto.ScrapRequest;
import dev.service.newsscrap.entity.Scrap;

import java.util.List;

public interface ScrapService {

    Scrap findById(Long id);
    List<Scrap> findAll();

    Scrap save(ScrapRequest scrapRequest);

    void deleteById(Long scrapId, Long memberId);
}
