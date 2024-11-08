package com.ameda.kevin.kisevu.works.votes.service;
/*
*
@author ameda
@project votes
*
*/

import com.ameda.kevin.kisevu.works.votes.entity.OptionVote;
import com.ameda.kevin.kisevu.works.votes.exceptions.PollCouldNotBeFound;
import com.ameda.kevin.kisevu.works.votes.exceptions.PollNotFound;
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

    public void vote(Long pollId, int optionIndex) throws PollNotFound {
        Poll poll = pollrepository.findById(pollId)
                .orElseThrow(()->new PollNotFound("poll with the passed id could not be found."));
        List<OptionVote> pollOptions = poll.getOptions();
        if(optionIndex < 0 || optionIndex>=pollOptions.size()){
            throw new IllegalArgumentException("Invalid option index discovered.");
        }
        OptionVote selectedOption = pollOptions.get(optionIndex);
        selectedOption.setVoteCount(selectedOption.getVoteCount()+1);
        pollrepository.save(poll);
    }
}
