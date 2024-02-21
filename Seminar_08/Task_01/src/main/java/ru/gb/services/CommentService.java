package ru.gb.services;

import org.springframework.stereotype.Service;
import ru.gb.model.Comment;
//@Service
public class CommentService {
    public String publishComment(Comment comment){
        System.out.println("Comment author: " + comment.getAuthor() + "\nComment text: " + comment.getComment());
        return comment.getComment();
    }
}
