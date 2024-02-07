package dev.service.newsscrap.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Scrap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "news_id")
    private News news;

    private String comment;

    @Column(nullable = false)
    private String keyword;

    @Column(nullable = false)
    private LocalDateTime createdTime;

    @Column(nullable = false)
    private LocalDateTime updatedTime;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Scrap(Long id, News news, String comment, String keyword, LocalDateTime createdTime, LocalDateTime updatedTime, Member member) {
        this.id = id;
        this.news = news;
        this.comment = comment;
        this.keyword = keyword;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.member = member;
    }

    public void updateScrap(News news, String comment, String keyword, LocalDateTime updatedTime) {
        this.news = news;
        this.comment = comment;
        this.keyword = keyword;
        this.updatedTime = updatedTime;
    }
}