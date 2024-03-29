package com.example.bootlanuch.service;

import com.example.bootlanuch.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ArticleService {
    public  void saveArticle(Article article);
    void deleteArticle(Long id);
    void  updateArticle(Article article);
    Article getArticle(Long id);
    List<Article> getAll();
}
