package com.ameda.kevin.kisevu.works.votes.repo;/*
*
@author ameda
@project votes
*
*/

import com.ameda.kevin.kisevu.works.votes.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll,Long> {
}
