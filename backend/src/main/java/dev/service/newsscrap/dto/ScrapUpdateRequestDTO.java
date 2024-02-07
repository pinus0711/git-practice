package dev.service.newsscrap.dto;

import dev.service.newsscrap.entity.News;
import dev.service.newsscrap.entity.Scrap;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ScrapUpdateRequestDTO {
    private Long id;
    private Long newsId;
    private String comment;
    private String keyword;
    public Scrap toEntity(News news) {

        return Scrap.builder()
                .id(id)
                .news(news)
                .comment(comment)
                .keyword(keyword)
                .build();
    }
}
