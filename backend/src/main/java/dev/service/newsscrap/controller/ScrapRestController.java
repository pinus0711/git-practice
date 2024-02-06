package dev.service.newsscrap.controller;

import dev.service.newsscrap.dto.ScrapRequest;
import dev.service.newsscrap.service.ScrapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/scrap")
@RestController
@RequiredArgsConstructor
public class ScrapRestController {

    private final ScrapService scrapService;

    @PostMapping("/create")
    public void addScrap(@RequestBody ScrapRequest scrapRequest) {

        scrapService.save(scrapRequest);
    }

}