package com.publisher.WriterPad.Repository;

import com.publisher.WriterPad.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    public Article findArticleByArticleId(Long id);
}
