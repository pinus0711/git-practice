package dev.service.newsscrap.dto;

import dev.service.newsscrap.entity.Member;
import dev.service.newsscrap.entity.Scrap;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
public class ScrapRequestDTO {

    private String url;
    private String title;
    private String content;
    private String comment;
    private String keyword;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    private Long memberId;

    public ScrapRequestDTO(String url, String title, String content, String comment, String keyword, LocalDateTime createdTime, LocalDateTime updatedTime, Long memberId) {
        this.url = url;
        this.title = title;
        this.content = content;
        this.comment = comment;
        this.keyword = keyword;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;

        this.memberId = memberId;
    }

    public static Scrap toEntity(ScrapRequestDTO scrapRequestDTO, Member member) {
        return  Scrap.builder()
                .comment(scrapRequestDTO.getComment())
                .title(scrapRequestDTO.getTitle())
                .content(scrapRequestDTO.getContent())
                .url(scrapRequestDTO.getUrl())
                .keyword(scrapRequestDTO.getKeyword())
                .createdTime(scrapRequestDTO.getCreatedTime())
                .updatedTime(scrapRequestDTO.getUpdatedTime())
                .member(member).build();
    }
}