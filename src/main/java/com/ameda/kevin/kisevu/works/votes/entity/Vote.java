package com.ameda.kevin.kisevu.works.votes.entity;
/*
*
@author ameda
@project votes
*
*/

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vote {
    private Long pollId;
    private int optionIndex;
}
