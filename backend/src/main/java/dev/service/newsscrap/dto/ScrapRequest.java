package dev.service.newsscrap.dto;

import dev.service.newsscrap.entity.Scrap;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
public class ScrapRequest {

    private String url;
    private String title;
    private String content;
    private String comment;
    private String keyword;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    private Long member_id;

    public ScrapRequest(String url, String title, String content, String comment, String keyword, LocalDateTime createdTime, LocalDateTime updatedTime, Long member_id) {
        this.url = url;
        this.title = title;
        this.content = content;
        this.comment = comment;
        this.keyword = keyword;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;

        this.member_id = member_id;
    }

    public Scrap toEntity() {
        return Scrap.builder()
                .url(url)
                .title(title)
                .content(content)
                .keyword(keyword)
                .createdTime(createdTime)
                .updatedTime(updatedTime).build();
        // TODO: DB에서 ID를 기준으로 Member 정보를 가져와서 설정하기
//                .member().build();
    }
}