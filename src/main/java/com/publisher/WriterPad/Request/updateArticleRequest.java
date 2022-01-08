package com.publisher.WriterPad.Request;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class updateArticleRequest {

    @NotNull(message = "Id is required for the request")
    public long id;
    public String title;
    public String body;
    public String description;
    public ArrayList<String> tags;
    public boolean favorited;

}
