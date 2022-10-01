import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { isEmpty } from 'rxjs';
import { UserAccountDetails } from '../list-user-account-details/list-user-account-details.component';
import { UserAccountDetailsDataService } from '../service/data/user-account-details-data.service';

@Component({
  selector: 'app-user-account-details',
  templateUrl: './user-account-details.component.html',
  styleUrls: ['./user-account-details.component.css']
})
export class UserAccountDetailsComponent implements OnInit {

  userId!: number;
  userAccountNo!: number;
  userAccountDetails! : UserAccountDetails;
  message! : string;

  constructor(
    private userAccountDetailsDataService : UserAccountDetailsDataService,
    private route : ActivatedRoute,
    private router : Router
    ) { }

  ngOnInit() {
    this.userId = this.route.snapshot.params['userId'];
    this.userAccountNo = this.route.snapshot.params['userAccountNo'];

    // this.userAccountDetails = new UserAccountDetails(this.userId,123456789013241,'SAVINGS',new Date(),'INDIVIDUAL','');

    if(this.userId>1000){
      this.userAccountDetailsDataService.getUserAccountDetailsByIdBeanService(this.userAccountNo)
        .subscribe(
          userAccountDetailsData =>this.userAccountDetails = userAccountDetailsData 
        )
    }

  }

  saveUserAccountDetails() {
    if(this.userId===this.userAccountDetails.userId) { 
      if(this.userAccountDetails.operationType==='INDIVIDUAL'){
        this.userAccountDetails.secondOperatorName='';
      }
      this.userAccountDetailsDataService.updateUserAccountDetailsByIdBeanService(this.userAccountNo, this.userAccountDetails)
          .subscribe (
            userAccountDetailsData => {
              console.log(userAccountDetailsData)
              this.router.navigate(['userAccountDetails'])
            }
          )
    } else {
      this.message = "User Doesn't exist";
    }

  }
}
