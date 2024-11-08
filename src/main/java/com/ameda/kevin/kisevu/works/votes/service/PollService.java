package com.ameda.kevin.kisevu.works.votes.service;
/*
*
@author ameda
@project votes
*
*/

import com.ameda.kevin.kisevu.works.votes.exceptions.PollCouldNotBeFound;
import com.ameda.kevin.kisevu.works.votes.repo.PollRepository;
import com.ameda.kevin.kisevu.works.votes.entity.Poll;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PollService {

    private final PollRepository pollrepository;

    public Poll createPoll(Poll poll) {
        return pollrepository.save(poll);
    }

    public List<Poll> getPolls() {
        return pollrepository.findAll();
    }

    public Poll getPollById(Long id) throws PollCouldNotBeFound {
        return pollrepository.findById(id)
                .orElseThrow(()->new PollCouldNotBeFound("Poll object could not be found."));
    }
}
