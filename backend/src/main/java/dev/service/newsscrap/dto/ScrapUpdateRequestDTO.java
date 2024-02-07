package dev.service.newsscrap.dto;

import dev.service.newsscrap.entity.Scrap;
import dev.service.newsscrap.service.NewsService;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ScrapUpdateRequestDTO {
    private Long id;
    private Long newsId;
    private String comment;
    private String keyword;
    private LocalDateTime updatedTime;

    private final NewsService newsService;

    public Scrap toEntity() {

        return Scrap.builder()
                .id(id)
                .news(newsService.findById(newsId))
                .comment(comment)
                .keyword(keyword)
                .updatedTime(updatedTime)
                .build();
    }
}
