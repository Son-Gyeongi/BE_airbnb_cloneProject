package com.sparta.airbnb_clone_be.repository;

import com.sparta.airbnb_clone_be.model.Accommodation;
import com.sparta.airbnb_clone_be.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository  extends JpaRepository<Comment,Long> {
    List<Comment> FindAllbyCommentsOrderbyModifiedAtDesc(Accommodation id);
    List<Comment> findAllByAccomodation_Id(long accomdationsId);
}
