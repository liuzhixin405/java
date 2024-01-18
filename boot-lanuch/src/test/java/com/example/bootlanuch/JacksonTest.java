package com.example.bootlanuch;

import com.example.bootlanuch.model.Article;
import com.example.bootlanuch.model.Reader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JacksonTest {
    @Test
    void testJackson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Reader> readers = new ArrayList<Reader>(){{
            add(new Reader("Jack",22));
            add(new Reader("Mark",30));
        }};
        Article article = Article.builder().author("lzx")
                .id(2L)
                .content("spring boot learing")
                .createTime(new Date())

                .reader(readers).title("t1")
                .build();
        String jsonStr = mapper.writeValueAsString(article);
        System.out.println(jsonStr);

        //{"content":"spring boot learing","title":"t1","id":2,"createTime":"2024/01/18 18:35:30","reader":[{"name":"Jack","age":22},{"name":"Mark","age":30}],"作者":"lzx"}
       Article objToArticle = mapper.readValue("{\"content\":\"spring boot learing\",\"title\":\"t1\",\"id\":2,\"createTime\":\"2024/01/18 18:35:30\",\"reader\":[{\"name\":\"Jack\",\"age\":22},{\"name\":\"Mark\",\"age\":30}],\"作者\":\"lzx\"}",Article.class);
        System.out.println(objToArticle);
    }
}
