package dev.service.newsscrap.dto;

import dev.service.newsscrap.entity.Scrap;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ScrapUpdateResponseDTO {
    private Long id;
    private String url;
    private String title;
    private String content;
    private String comment;
    private String keyword;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public static ScrapUpdateResponseDTO toDTO(Scrap scrap) {
        final Long id = scrap.getId();
        final String url = scrap.getUrl();
        final String title = scrap.getTitle();
        final String content = scrap.getContent();
        final String comment = scrap.getComment();
        final String keyword = scrap.getKeyword();
        final LocalDateTime createdTime = scrap.getCreatedTime();
        final LocalDateTime updatedTime = scrap.getUpdatedTime();

        return new ScrapUpdateResponseDTO(id, url, title, content, comment, keyword, createdTime, updatedTime);
    }
}
