package dev.service.newsscrap.dto;

import dev.service.newsscrap.entity.News;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@Builder
public class NewsResponse {
    private int total;
    private int start;
    private int display;
    List<News> news;
}
