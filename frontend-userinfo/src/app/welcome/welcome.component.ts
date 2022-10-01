import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HelloWorld, UserDetailsDataService } from '../service/data/user-details-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {


  constructor(private route: ActivatedRoute, private service: UserDetailsDataService) {

   }

  ngOnInit(): void {
  }

  

}
