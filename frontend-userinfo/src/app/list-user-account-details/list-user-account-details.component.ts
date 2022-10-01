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
  userAccountNo! : number;
  userId! : number;

  constructor(private userAccountDetailsDataService : UserAccountDetailsDataService, private router : Router, private route : ActivatedRoute) { }


  ngOnInit(): void {
    this.userAccountNo = this.route.snapshot.params['userAccountNo']
    // this.userId = this.route.snapshot.params['userId']
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


    getUserAccountDetailsById(userAccountNo: number){
    this.userAccountDetailsDataService.getUserAccountDetailsByIdBeanService(userAccountNo).subscribe(
      response => {
        console.log(response),
        console.log(this.userAccountDetails)
      }
    )
    }

  deleteUserAccountDetailsById(userAccountNo : number){
    console.log(`deleted User Account Details ${userAccountNo}`);
    this.userAccountDetailsDataService.deleteUserAccountDetailsByIdBeanService(userAccountNo).subscribe(
      response => {
        console.log(response);
        console.log(userAccountNo);
        this.message = `Deleted of User Account Details ${userAccountNo} Successful`;
        this.getUserAccountDetails();
      }
    )
    }

  //   updateUserAccountDetailsById(userAccountNo: number){
  //     console.log(`update ${userAccountNo}`);
  //     this.router.navigate([`userAccountDetails/${userAccountNo}`]);
 
  // }
  updateUserAccountDetailsById(userAccountNo: number){
        console.log(`update ${userAccountNo}`);
        this.router.navigate([`userAccountDetails/${userAccountNo}`]);
   
    }

  //  addUserAccountDetails(){
  //    this.router.navigate(['addUserAccountDetails']);
  //  }

}
