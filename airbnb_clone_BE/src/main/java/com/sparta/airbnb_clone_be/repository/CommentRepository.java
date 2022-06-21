package com.sparta.airbnb_clone_be.repository;

import com.sparta.airbnb_clone_be.model.Accomodations;
import com.sparta.airbnb_clone_be.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository  extends JpaRepository<Comment,Long> {
    List<Comment> FindAllbyCommentsOrderbyModifiedAtDesc(Accomodations id);
    List<Comment> findAllByAccomodations_Id(long accomdationsId);

    List<Comment> findAllByCheckin();

    List<Comment> findAllByClean();

    List<Comment> findAllByAccuracy();

    List<Comment> findAllByCommunication();

    List<Comment> findAllByLocation();

    List<Comment> findAllBySatisfaction();
//
//    void deleteByComment(Accomodations accomodations);
}
