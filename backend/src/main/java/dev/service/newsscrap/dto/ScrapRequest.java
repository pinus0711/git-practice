package dev.service.newsscrap.dto;

import dev.service.newsscrap.entity.Member;
import dev.service.newsscrap.entity.News;
import dev.service.newsscrap.entity.Scrap;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ScrapRequest {
    private String comment;
    private String keyword;

    private Long memberId;
    private Long newsId;

    public ScrapRequest(String comment, String keyword, Long memberId, Long newsId) {
        this.comment = comment;
        this.keyword = keyword;

        this.memberId = memberId;
        this.newsId = newsId;
    }

    public Scrap toEntity(Member member, News news) {
        return  Scrap.builder()
                .comment(comment)
                .keyword(keyword)
                .member(member)
                .news(news)
                .build();
    }
}