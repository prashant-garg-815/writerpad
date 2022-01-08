package com.publisher.WriterPad.Request;

import javax.validation.constraints.NotBlank;

public class CommentRequest {

    @NotBlank(message = "Comment cannot be blank")
    public String body;

}
