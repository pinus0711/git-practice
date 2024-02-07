package dev.service.newsscrap.dto;

import dev.service.newsscrap.entity.Member;
import dev.service.newsscrap.entity.News;
import dev.service.newsscrap.entity.Scrap;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class ScrapRequest {
    private String comment;
    private String keyword;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    private Long memberId;
    private Long newsId;

    public ScrapRequest(String comment, String keyword, LocalDateTime createdTime, LocalDateTime updatedTime, Long memberId, Long newsId) {
        this.comment = comment;
        this.keyword = keyword;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;

        this.memberId = memberId;
        this.newsId = newsId;
    }

    public static Scrap toEntity(ScrapRequest scrapRequest, Member member, News news) {
        return  Scrap.builder()
                .comment(scrapRequest.getComment())
                .keyword(scrapRequest.getKeyword())
                .createdTime(scrapRequest.getCreatedTime())
                .updatedTime(scrapRequest.getUpdatedTime())
                .member(member)
                .news(news)
                .build();
    }
}