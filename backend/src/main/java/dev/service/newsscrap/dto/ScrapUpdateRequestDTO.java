package dev.service.newsscrap.dto;

import dev.service.newsscrap.entity.Scrap;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ScrapUpdateRequestDTO {
    private Long id;
    private String url;
    private String title;
    private String content;
    private String comment;
    private String keyword;
    private LocalDateTime updatedTime;

    public Scrap toEntity() {
        return Scrap.builder()
                .id(id)
                .url(url)
                .title(title)
                .content(content)
                .comment(comment)
                .keyword(keyword)
                .updatedTime(updatedTime)
                .build();
    }
}
