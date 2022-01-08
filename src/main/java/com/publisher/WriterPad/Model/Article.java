package com.publisher.WriterPad.Model;

import com.publisher.WriterPad.Request.ArticleRequest;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "article_id")
    private long articleId;

    @Column(name = "title")
    private String title;

    private String slug;
    private String body;
    private String desciption;
    private String[] tags;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "modified_at")
    private String modifiedAt;

    private boolean favorited;

    @Column(name = "favorite_counter")
    private int favoriteCounter;

    @OneToMany(mappedBy = "article")
    private List<Comment> comment;

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment.add(comment);
    }

    public Article(){

    }

    public Article(ArticleRequest reqArticle){
        this.title = reqArticle.title;
        this.body = reqArticle.body;
        this.desciption = reqArticle.description;
        this.tags = reqArticle.tags;
        this.favoriteCounter = reqArticle.favoriteCounter;
        this.favorited = reqArticle.favorited;
    }

    public long getArticleIdId() {
        return articleId;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }

    public String getBody() {
        return body;
    }

    public String getDesciption() {
        return desciption;
    }

    public String[] getTags() {
        return tags;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public int getFavoriteCounter() {
        return favoriteCounter;
    }

    public void setId(long id) {
        this.articleId = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public void setFavoriteCounter(int favoriteCounter) {
        this.favoriteCounter = favoriteCounter;
    }
}
