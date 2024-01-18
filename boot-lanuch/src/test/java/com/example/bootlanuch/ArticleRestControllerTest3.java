package com.example.bootlanuch;


import com.example.bootlanuch.model.Article;
import com.example.bootlanuch.service.ArticleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest
//@WebMvcTest(ArticleRestControllerTest.class) //缩小加载的范围
@ExtendWith(SpringExtension.class)
public class ArticleRestControllerTest3 {
    @Resource
    private MockMvc mockMvc;        //有用到@Resource才注入@AutoConfigureMockMvc  @SpringBootTest  @ExtendWith(SpringExtension.class)
    @MockBean
    private ArticleService articelService;
//    @BeforeAll
//    static  void setUp(){
//        Object[] controllers;
//        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
//    }

    @Test
    public  void saveArticle() throws Exception{
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.POST,"/rest/articles")
                        .contentType("application/json")
                        .content("{\"content\":\"spring boot learing\",\"title\":\"t1\",\"id\":2,\"createTime\":\"2024/01/18 18:35:30\",\"reader\":[{\"name\":\"Jack\",\"age\":22},{\"name\":\"Mark\",\"age\":30}],\"作者\":\"lzx\"}")
        ).andDo(print()).andReturn();
    mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public  void saveArticleWithCondition() throws Exception{

       String articleString = "{\"content\":\"spring boot learing\",\"title\":\"t1\",\"id\":2,\"createTime\":\"2024/01/18 18:35:30\",\"reader\":[{\"name\":\"Jack\",\"age\":22},{\"name\":\"Mark\",\"age\":30}],\"author\":\"lzx\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        Article article = objectMapper.readValue(articleString, Article.class);
        when(articelService.saveArticle(article)).thenReturn("ok");
       MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.POST,"/rest/articles")
                        .contentType("application/json")
                        .content(articleString)
        )
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").value("ok")) //is ok
                //.andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("lzx"))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
                .andDo(print()).andReturn();

        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info(mvcResult.getResponse().getContentAsString());
    }
}
