package me.leewonjun.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.leewonjun.springbootdeveloper.domain.Article;
import me.leewonjun.springbootdeveloper.dto.AddArticleRequest;
import me.leewonjun.springbootdeveloper.dto.UpdateArticleRequest;
import me.leewonjun.springbootdeveloper.repository.BlogRepository;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntiry());
    }

    
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // self constructing
    public void deleteById(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found: "+id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
