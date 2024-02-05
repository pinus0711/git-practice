package dev.service.newsscrap.entity;

import com.sun.istack.NotNull;
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

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

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
    public Scrap(String url, String title, String content, String comment, String keyword, LocalDateTime createdTime, LocalDateTime updatedTime, Member member) {
        this.url = url;
        this.title = title;
        this.content = content;
        this.comment = comment;
        this.keyword = keyword;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.member = member;
    }
}