package com.example.bootlanuch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@JsonPropertyOrder(value={"content","title"})
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private Long id;
    @JsonProperty("author")
    private  String author;
    private  String title;
    private  String content;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Reader> reader;
}
