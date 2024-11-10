package com.ameda.kevin.kisevu.works.votes.entity;
/*
*
@author ameda
@project votes
*
*/

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class OptionVote {
    private String optionText;
    private Long voteCount = 0L;
}
