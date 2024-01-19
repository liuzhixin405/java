package com.example.bootlanuch.dao;

import com.example.bootlanuch.model.Article;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleJDBCDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public  void save(Article artice){
        jdbcTemplate.update("insert into article(author,title,content,createTime) values(?,?,?,?)",artice.getAuthor(),artice.getTitle(),artice.getContent(),artice.getCreateTime());
    }

    public  void deleteById(Long id){
        jdbcTemplate.update("delete from article where id=?",id);
    }
    public  void updateById(Article artice){
        jdbcTemplate.update("update article set author=?,title=?,content=?,createTime=? where id=?",artice.getAuthor(),artice.getTitle(),artice.getContent(),artice.getCreateTime(),artice.getId());
    }

    public  Article findById(Long id){
    return jdbcTemplate.queryForObject("select * from article where id=?",new Object[]{id},new BeanPropertyRowMapper<>(Article.class));
    }

    public  List<Article> findAll(){
        return (List<Article>) jdbcTemplate.query("select * from article ",new BeanPropertyRowMapper<>(Article.class));
    }
}
