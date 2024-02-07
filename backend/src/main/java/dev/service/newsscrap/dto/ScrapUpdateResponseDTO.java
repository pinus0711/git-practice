package dev.service.newsscrap.dto;

import dev.service.newsscrap.entity.News;
import dev.service.newsscrap.entity.Scrap;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ScrapUpdateResponseDTO {
    private Long id;
    private News news;
    private String comment;
    private String keyword;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public static ScrapUpdateResponseDTO toDTO(Scrap scrap) {
        final Long id = scrap.getId();
        final News news = scrap.getNews();
        final String comment = scrap.getComment();
        final String keyword = scrap.getKeyword();
        final LocalDateTime createdTime = scrap.getCreatedTime();
        final LocalDateTime updatedTime = scrap.getUpdatedTime();

        return new ScrapUpdateResponseDTO(id, news, comment, keyword, createdTime, updatedTime);
    }
}
