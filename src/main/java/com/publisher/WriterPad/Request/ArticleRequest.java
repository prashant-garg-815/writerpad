package com.publisher.WriterPad.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

public class ArticleRequest {

    @JsonProperty("title")
    @NotBlank(message = "Title cannot be empty")
    public String title;

    @NotBlank(message = "Description cannot be empty")
    public String description;

    public String[] tags;

    @NotBlank(message = "Body cannot be empty")
    public String body;

    public boolean favorited;

    public int favoriteCounter;

    public ArticleRequest() {

    }

}
