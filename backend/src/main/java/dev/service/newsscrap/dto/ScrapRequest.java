package dev.service.newsscrap.dto;

import dev.service.newsscrap.entity.Member;
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

    private Long memberId;

    public ScrapRequest(String url, String title, String content, String comment, String keyword, LocalDateTime createdTime, LocalDateTime updatedTime, Long memberId) {
        this.url = url;
        this.title = title;
        this.content = content;
        this.comment = comment;
        this.keyword = keyword;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;

        this.memberId = memberId;
    }

    public static Scrap toEntity(ScrapRequest scrapRequest, Member member) {
        return  Scrap.builder()
                .comment(scrapRequest.getComment())
                .title(scrapRequest.getTitle())
                .content(scrapRequest.getContent())
                .url(scrapRequest.getUrl())
                .keyword(scrapRequest.getKeyword())
                .createdTime(scrapRequest.getCreatedTime())
                .updatedTime(scrapRequest.getUpdatedTime())
                .member(member)
                .build();
    }
}