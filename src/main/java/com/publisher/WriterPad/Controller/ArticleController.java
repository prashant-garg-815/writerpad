package com.publisher.WriterPad.Controller;

import com.publisher.WriterPad.Model.Article;
import com.publisher.WriterPad.Request.ArticleRequest;
import com.publisher.WriterPad.Request.updateArticleRequest;
import com.publisher.WriterPad.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    public ArticleService articleService;

    @GetMapping("/")
    public List<Article> getAllArticles(@RequestParam(required = false) Integer page){
        if(page==null){
            return articleService.getAllArticles(1);
        }
        else
            return articleService.getAllArticles(page);
    }

    @GetMapping("/{slug-id}")
    public Article getArticleNById(@RequestParam("slug-id") String slug_id) {
        String[] Slug_id = slug_id.split("-");
        long id = Long.parseLong(Slug_id[Slug_id.length -1]);

        return articleService.getArticleById(id);
    }

    @PostMapping("/")
    public Article saveArticle(@Valid @RequestBody ArticleRequest article){

        return articleService.saveArticle(article);
    }

    @PatchMapping("/{slug-id}")
    public Article updateArticle(@Valid @RequestBody updateArticleRequest articleBody, @PathVariable("slug-id") String slug_id){
        String[] Slug_id = slug_id.split("-");
        long id = Long.parseLong(Slug_id[Slug_id.length -1]);

        Article prevArticle = articleService.getArticleById(id);

        if(articleBody.title != null && !articleBody.title.isEmpty()){
            prevArticle.setTitle(articleBody.title);
            prevArticle.setSlug(prevArticle.getTitle().toLowerCase(Locale.ROOT).replace(" ", "-"));
        }

        if(articleBody.description!=null && !articleBody.description.isEmpty()){
            prevArticle.setDesciption(articleBody.description);
        }

        if(articleBody.body!=null && !articleBody.body.isEmpty()){
            prevArticle.setBody(articleBody.body);
        }

        if(prevArticle.isFavorited()==articleBody.favorited){
            prevArticle.setFavorited(articleBody.favorited);
        }

        prevArticle.setModifiedAt(OffsetDateTime.now( ZoneOffset.UTC ).toString());
        return articleService.saveArticle(prevArticle);
    }

    @DeleteMapping("/{slug-id}")
    public void deleteArticle(@PathVariable("slug-id") String slug_id) {
        String[] temp = slug_id.split("-");
        Long id = Long.parseLong(temp[temp.length-1]);
        articleService.deleteArticle(id);
    }
}
