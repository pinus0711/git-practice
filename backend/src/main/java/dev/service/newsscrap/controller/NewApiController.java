package dev.service.newsscrap.controller;

import dev.service.newsscrap.dto.NewsResponse;
import dev.service.newsscrap.entity.News;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api/newsList")
@RequiredArgsConstructor
public class NewApiController {
    @Value("${SEARCH_API_BASE_URL}")
    private String baseUrl;
    @Value("${SEARCH_API_CLIENT_ID}")
    private String clientId;
    @Value("${SEARCH_API_CLIENT_KEY}")
    private String clientKey;

    @GetMapping
    public NewsResponse getList(@RequestParam(name = "query", required = true, defaultValue = "") String query,
                                      @RequestParam(name = "start", required = false, defaultValue = "1") int start,
                                      @RequestParam(name = "display", required = false, defaultValue = "30") int display) {

        try {
            String apiUrl = new StringBuilder(baseUrl)
                    .append("?query=").append(URLEncoder.encode(query, "UTF-8"))
                    .append("&start=").append(start)
                    .append("&display=").append(display)
                    .append("&sort=sim")
                    .toString();

            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("X-Naver-Client-Id", clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", clientKey);
            conn.setDoOutput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder data = new StringBuilder();
            String line = null;

            while((line = br.readLine()) != null) {
                data.append(line);
            }

            JSONObject result = new JSONObject(data.toString());

            return NewsResponse.builder()
                    .total(result.getInt("total"))
                    .start(result.getInt("start"))
                    .display(result.getInt("display"))
                    .news(News.fromJsonArray(result.getJSONArray("items")))
                    .build();

        } catch(IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
