import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserDetails } from '../list-user-details/list-user-details.component';
import { UserDetailsDataService } from '../service/data/user-details-data.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  userId!: number;
  userDetails! : UserDetails

  constructor(
    private userDetailsDataService : UserDetailsDataService,
    private route : ActivatedRoute,
    private router : Router
    ) { }

  ngOnInit() {
    this.userId = this.route.snapshot.params['userId'];
    
    this.userDetails = new UserDetails(1001,'','',1111111111,'',new Date());

    if(this.userId>1000){
      this.userDetailsDataService.getUserDetailsByIdBeanService(this.userId)
        .subscribe(
          userDetailsData =>this.userDetails = userDetailsData 
        )
    }

  }

  saveUserDetails() {
      this.userDetailsDataService.saveUserDetailsBeanService(this.userDetails)
          .subscribe (
            userDetailsData => {
              console.log(userDetailsData)
              this.router.navigate(['userDetails'])
            }
          )

  }
}
