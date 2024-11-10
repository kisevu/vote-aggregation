import { Component, OnInit } from '@angular/core';
import { PollService } from '../poll.service';
import { Poll } from '../poll.models';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-poll',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './poll.component.html',
  styleUrl: './poll.component.css'
})
export class PollComponent implements OnInit{
  newPoll: Poll = {
   id: 0,
   question: '',
   options: [
    {optionText: '',voteCount: 0},
    {optionText: '',voteCount: 0}
   ]
  };

  polls: Poll [] = [];
  constructor(private pollService: PollService) {}

  ngOnInit(): void {
    this.loadPolls();
  }

  loadPolls(){
    this.pollService.getPolls().subscribe({
      next: (data) => {
        this.polls = data;
      },
      error: (error) => {
        console.error("Error fetching polls: ",error);
      }
    });
  }

  trackByIndex( index: number): number {
    return index;
  }

  createPoll(){
    this.pollService.createPoll(this.newPoll).subscribe({
      next: (data) => {
        this.polls.push(data);
        this.resetPollAfterCreation();
      },
      error: (error) => {
        console.error("could not create poll",error);
      }
    });
  }

  resetPollAfterCreation(){
    this.newPoll= {
      id: 0,
      question: '',
      options: [
       {optionText: '',voteCount: 0},
       {optionText: '',voteCount: 0}
      ]
     };
  }

}
