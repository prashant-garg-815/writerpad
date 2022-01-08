package com.publisher.WriterPad.Repository;

import com.publisher.WriterPad.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("select comment from Article art where art.articleId = :id")
    public List<Comment> findCommentByArticleId(Long id);
}