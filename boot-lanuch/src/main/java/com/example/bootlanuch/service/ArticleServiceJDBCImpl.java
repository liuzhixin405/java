package com.example.bootlanuch.service;

import com.example.bootlanuch.dao.ArticleJDBCDAO;
import com.example.bootlanuch.model.Article;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
public class ArticleServiceJDBCImpl implements ArticleService {
    @Resource
    ArticleJDBCDAO articleJDBCDAO;
    @Override
    public void saveArticle(Article article) {
        articleJDBCDAO.save(article);
    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void updateArticle(Article article) {
        if(article.getId()==null){
            //TODO 抛出自定义异常
        }
        //articleJDBCDAO.updateById(article);
        articleJDBCDAO.deleteById(article.getId());

        int i=10/0;     //测试事务
        articleJDBCDAO.save(article);
    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDAO.findById(id);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.findAll();
    }
}
