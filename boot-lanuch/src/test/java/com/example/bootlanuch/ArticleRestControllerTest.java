package com.example.bootlanuch;


import com.example.bootlanuch.controller.ArticleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import  org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
public class ArticleRestControllerTest {

    private  static MockMvc mockMvc;

    @BeforeAll
    static  void setUp(){
        Object[] controllers;
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }

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
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.POST,"/rest/articles")
                        .contentType("application/json")
                        .content("{\"content\":\"spring boot learing\",\"title\":\"t1\",\"id\":2,\"createTime\":\"2024/01/18 18:35:30\",\"reader\":[{\"name\":\"Jack\",\"age\":22},{\"name\":\"Mark\",\"age\":30}],\"author\":\"lzx\"}")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("lzx"))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
                .andDo(print()).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info(mvcResult.getResponse().getContentAsString());
    }
}
