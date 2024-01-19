package com.example.bootlanuch.controller;

import com.example.bootlanuch.AjaxResponse;
import com.example.bootlanuch.model.Article;
import com.example.bootlanuch.model.Reader;
import com.example.bootlanuch.service.ArticleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleController {

    @Resource
    ArticleService articleService;

    //查询
    @RequestMapping(value = "/articles/{id}",method = RequestMethod.GET)
    public AjaxResponse getArticle(@PathVariable("id") Long id){

//        List<Reader> readers = new ArrayList<Reader>(){{
//           add(new Reader("Jack",22));
//           add(new Reader("Mark",30));
//        }};
//                Article article = Article.builder().author("lzx")
//                        .id(id)
//                        .content("spring boot learing")
//                        .createTime(new Date())
//
//                        .reader(readers).title("t1")
//                        .build();

        Article article = articleService.getArticle(id);
                log.info("Article:"+article);
                return AjaxResponse.success(article);
    }

    @RequestMapping(value = "/articles",method = RequestMethod.POST)
    public AjaxResponse saveArticle(@RequestBody Article article){
        articleService.saveArticle(article);
        log.info("saveArticle:"+article);
        return AjaxResponse.success();
        //return AjaxResponse.success(articleService.saveArticle(article));
    }

    @RequestMapping(value = "/articles",method = RequestMethod.PUT)
    public AjaxResponse updateArticle(@RequestBody Article article){
        if(article.getId()==null){
            //
        }
        articleService.updateArticle(article);
        log.info("updateArticle:"+article);
        return AjaxResponse.success();
    }

    @RequestMapping(value = "/articles",method = RequestMethod.GET)
    public AjaxResponse getArticles(){
      List<Article> articles = articleService.getAll();
        log.info("getArticle:"+articles );
        return AjaxResponse.success(articles);
    }
}
