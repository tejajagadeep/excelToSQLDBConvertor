import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserAccountDetailsDataService } from '../service/data/user-account-details-data.service';

export class UserAccountDetails{
  constructor(
    public userId : number,
    public userAccountNo : number,
    public userAccountType : string,
    public accountCreationDate : Date,
    public operationType : string,
    public secondOperatorName : string
  ){

  }
}

@Component({
  selector: 'app-list-user-account-details',
  templateUrl: './list-user-account-details.component.html',
  styleUrls: ['./list-user-account-details.component.css']
})
export class ListUserAccountDetailsComponent implements OnInit {

  userAccountDetails!: UserAccountDetails[];
  message! : String;
  userId! : number;
  

  constructor(private userAccountDetailsDataService : UserAccountDetailsDataService, private router : Router, private route : ActivatedRoute) { }


  ngOnInit(): void {
    this.userId = this.route.snapshot.params['userId']
    
    this.getUserAccountDetails();
  }

  getUserAccountDetails(){
    this.userAccountDetailsDataService.getUserAccountDetailsBeanService().subscribe(
      response => {
        console.log(response);
        this.userAccountDetails = response;
        console.log(this.userAccountDetails)
      }
    )
    }


    getUserAccountDetailsById(){
    this.userAccountDetailsDataService.getUserAccountDetailsBeanService().subscribe(
      response => {
        console.log(response);
        this.userAccountDetails = response;
        console.log(this.userAccountDetails)
      }
    )
    }

  deleteUserAccountDetailsById(userId : number){
    console.log(`deleted User Account Details ${userId}`);
    this.userAccountDetailsDataService.deleteUserAccountDetailsByIdBeanService(userId).subscribe(
      response => {
        console.log(response);
        console.log(userId);
        this.message = `Delete of User Account Details ${userId} Successful`;
        this.getUserAccountDetails();
      }
    )
    }

  updateUserAccountDetailsById(userId: number){
        console.log(`update ${userId}`);
        this.router.navigate([`userAccountDetails/${userId}`]);
   
    }

   addUserAccountDetails(){
     this.router.navigate(['addUserAccountDetails']);
   }

}
