import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserDetailsDataService } from '../service/data/user-details-data.service';

export class UserDetails{
  constructor(
    public  userId : number,
    public  userFName : String,
    public  userLName : String,
    public  userMobileNumber : number,
    public  userEmailId : String,
    public  userCreatedDate : Date
  ){

  }
}

@Component({
  selector: 'app-list-user-details',
  templateUrl: './list-user-details.component.html',
  styleUrls: ['./list-user-details.component.css']
})
export class ListUserDetailsComponent implements OnInit {

  userDetails!: UserDetails[];
  
  userId! : number;

  message!: string;
  
  // [
  //   new UserDetails(1001,'Virendra', 'Shewag',1111111111, 'Viru@gmail.com',new Date("2022-07-27")),
  //   new UserDetails(1002, 'Anil', 'Kumble',1111111112, 'Anil@gmail.com',new Date("2022-07-27")),
  //   new UserDetails(1003, 'Sachin', 'Tendulkar',1111111113, 'SRT@gmail.com',new Date("2022-07-25"))
  // ]
  
  // [
  //   new UserDetails(1001,'Virendra', 'Shewag',1111111111, 'Viru@gmail.com',new Date("2022-07-27")),
  //   new UserDetails(1002, 'Anil', 'Kumble',1111111112, 'Anil@gmail.com',new Date("2022-07-27")),
  //   new UserDetails(1003, 'Sachin', 'Tendulkar',1111111113, 'SRT@gmail.com',new Date("2022-07-25"))

  // ]

  constructor(private userDetailsDataService : UserDetailsDataService, private router : Router, private route : ActivatedRoute) { }

  ngOnInit() {
    this.userId = this.route.snapshot.params['userId']

    // this.userDetailsDataService.getUserDetailsBeanService().subscribe(
    //   response => {
    //     console.log(response);
    //     this.userDetails = response;
    //     console.log(this.userDetails)
    //   }
    // )
    this.getUserDetails();

    
    

  }

  getUserDetails(){
    this.userDetailsDataService.getUserDetailsBeanService().subscribe(
      response => {
        console.log(response);
        this.userDetails = response;
        console.log(this.userDetails)
      }
    )
    }


    getUserDetailsById(){
    this.userDetailsDataService.getUserDetailsBeanService().subscribe(
      response => {
        console.log(response);
        this.userDetails = response;
        console.log(this.userDetails)
      }
    )
    }

  deleteUserDetailsById(userId : number){
    // this.user_id =user_id;
    console.log(`delete User Details ${userId}`);
    this.userDetailsDataService.deleteUserDetailsByIdBeanService(userId).subscribe(
      response => {
        console.log(response);
        console.log(userId);
        // this.userDetails = response;
        this.message = `Deleted of User Details ${userId} Successful`;
        this.getUserDetails();
      }
    )
    }

  updateUserDetailsById(userId: number){
    // this.userDetailsDataService.updateUserDetailsByIdBeanService(this.user_id, this.userDetails).subscribe(
    //   response => {
    //     console.log(response);
        console.log(`update ${userId}`);
        // console.log(this.router.navigate(['userDetails', userId]));
        this.router.navigate([`userDetails/${userId}`]);
    //     this.userDetails = response;
      // }
    // )

      // console.log(`update ${userId}`)
      // this.router.navigate(['addUserDetails',userId])
    }

   addUserDetails(){
     this.router.navigate(['addUserDetails']);
   }

}
