package com.publisher.WriterPad.Service;

import com.publisher.WriterPad.Model.Article;
import com.publisher.WriterPad.Repository.ArticleRepository;
import com.publisher.WriterPad.Request.ArticleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Locale;

@Service
public class ArticleService {

    @Autowired
    public ArticleRepository articleRepo;

    @Value("${page_size}")
    private Integer pageSize;

    public List<Article> getAllArticles(Integer pageNo) {
        Pageable pageable = Pageable.ofSize(this.pageSize);
        return articleRepo.findAll(pageable.withPage(pageNo-1)).getContent();
    }

    public Article saveArticle(ArticleRequest articleReq) {
        Article article = new Article(articleReq);
        // Adding slug and timestamps
        article.setSlug(article.getTitle().toLowerCase(Locale.ROOT).replace(" ", "-"));
        OffsetDateTime now = OffsetDateTime.now( ZoneOffset.UTC );
        article.setCreatedAt(now.toString());
        article.setModifiedAt(now.toString());

        return articleRepo.save(article);
    }

    public Article saveArticle(Article article) {
        return articleRepo.save(article);
    }

    public Article getArticleById(Long id){
        return articleRepo.findArticleByArticleId(id);
    }

    public void deleteArticle(Long id) {
        articleRepo.deleteById(id);
    }

}
