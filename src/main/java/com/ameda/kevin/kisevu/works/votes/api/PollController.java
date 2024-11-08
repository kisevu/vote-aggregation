package com.ameda.kevin.kisevu.works.votes.api;
/*
*
@author ameda
@project votes
*
*/

import com.ameda.kevin.kisevu.works.votes.exceptions.PollCouldNotBeFound;
import com.ameda.kevin.kisevu.works.votes.service.PollService;
import com.ameda.kevin.kisevu.works.votes.entity.Poll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
@RequiredArgsConstructor
public class PollController {
    private final PollService pollService;
    @PostMapping("/poll/create")
    public ResponseEntity<Poll> createPoll(@RequestBody Poll poll){
        return new ResponseEntity<>(pollService.createPoll(poll), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Poll>> getPolls(){
        return new ResponseEntity<>(pollService.getPolls(),HttpStatus.OK);
    }

    @GetMapping("/poll/{id}")
    public ResponseEntity<?> getPollById(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(pollService.getPollById(id),HttpStatus.FOUND);
        }catch (PollCouldNotBeFound ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
}
