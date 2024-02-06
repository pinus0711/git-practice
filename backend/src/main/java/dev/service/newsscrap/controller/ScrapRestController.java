package dev.service.newsscrap.controller;

import dev.service.newsscrap.dto.ScrapRequest;
import dev.service.newsscrap.service.ScrapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/scrap")
@RestController
@RequiredArgsConstructor
public class ScrapRestController {

    private final ScrapService scrapService;

    @PostMapping("/create")
    public void addScrap(@RequestBody ScrapRequest scrapRequest) {

        scrapService.save(scrapRequest);
    }

    @PostMapping("/delete")
    public void deleteScrap(@RequestParam Long scrapId, Long memberId) {

        scrapService.deleteById(scrapId, memberId);
    }
}