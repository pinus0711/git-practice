package dev.service.newsscrap.controller;

import dev.service.newsscrap.dto.ScrapRequest;
import dev.service.newsscrap.entity.Scrap;
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

    // ScrapService 의존성 주입
    private final ScrapService scrapService;

    @PostMapping("/create")
    public void addScrap(@RequestBody ScrapRequest scrapRequest) {
        System.out.println("scrap = " + scrapRequest);

        scrapRequest.toEntity();

        scrapService.save(scrapRequest.toEntity());
    }

}