package com.publisher.WriterPad.Service;

import com.publisher.WriterPad.Model.Comment;
import com.publisher.WriterPad.Repository.CommentRepository;
import com.publisher.WriterPad.Request.CommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments (Long id) {
        return commentRepository.findCommentByArticleId(id);
    }

    public Comment saveComment(CommentRequest commentRequest, HttpServletRequest requestIP) {

        Comment comment = new Comment(commentRequest);
        comment.setIpAddress(requestIP.getRemoteAddr());

        OffsetDateTime now = OffsetDateTime.now( ZoneOffset.UTC );

        comment.setCreatedAt(now.toString());
        comment.setLastModifiedAt(now.toString());

        comment = commentRepository.save(comment);
        return comment;
    }
}
