package com.publisher.WriterPad.Model;

import com.publisher.WriterPad.Request.CommentRequest;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private long commentId;
    private String body;
    private String createdAt;
    private String lastModifiedAt;
    private String ipAddress;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    public Comment(){

    }

    public Comment(CommentRequest comment){
        this.body = comment.body;
    }

    public long getId() {
        return commentId;
    }

    public String getBody() {
        return body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getLastModifiedAt() {
        return lastModifiedAt;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setId(long id) {
        this.commentId = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setLastModifiedAt(String lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
