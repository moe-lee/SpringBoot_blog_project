package me.leewonjun.springbootdeveloper.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.leewonjun.springbootdeveloper.domain.Article;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntiry() {
        return Article.builder()
                .content(content)
                .title(title)
                .build();
    }
}