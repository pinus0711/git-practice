package dev.service.newsscrap.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class News {
    private String title;
    private String originallink;
    private String link;
    private String description;
    private LocalDateTime pubDate;

    public static List<News> fromJsonArray(JSONArray jsonArray) {
        List<News> newsList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME.withLocale(Locale.ENGLISH);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);

            ZonedDateTime zonedDateTime = ZonedDateTime.parse(json.getString("pubDate"), formatter);
            LocalDateTime pubDate = zonedDateTime.toLocalDateTime();

            newsList.add(News.builder()
                            .title(json.getString("title"))
                            .link(json.getString("link"))
                            .originallink(json.getString("originallink"))
                            .description(json.getString("description"))
                            .pubDate(pubDate)
                            .build()
            );
        }

        return newsList;
    }
}
