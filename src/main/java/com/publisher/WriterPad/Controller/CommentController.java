package com.publisher.WriterPad.Controller;

import com.publisher.WriterPad.Model.Article;
import com.publisher.WriterPad.Model.Comment;
import com.publisher.WriterPad.Request.CommentRequest;
import com.publisher.WriterPad.Service.ArticleService;
import com.publisher.WriterPad.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

import static org.aspectj.runtime.internal.Conversions.longValue;

@RestController
@RequestMapping(value = "/api/articles/{slug-id}/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public List<Comment> getComments(@PathVariable("slug-id") String slug_id) {
        String[] id = slug_id.split("-");
        return commentService.getAllComments(Long.parseLong(id[id.length-1]));
    }

    @PostMapping("/")
    public Comment postComment(@PathVariable("slug-id") String slug_id, @Valid @RequestBody CommentRequest commentRequest, HttpServletRequest requestIP) {
        Comment comment = commentService.saveComment(commentRequest, requestIP);

        String[] id = slug_id.split("-");
        Article article = articleService.getArticleById(Long.parseLong(id[id.length-1]));
        article.setComment(comment);
        articleService.saveArticle(article);
        return comment;
    }
}
