import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HelloWorld, UserDetailsDataService } from '../service/data/user-details-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  welcomeMessageFromService!: string;
  welcomeErrorMessageFromService!: string;

  constructor(private route: ActivatedRoute, private service: UserDetailsDataService) {

   }

  ngOnInit(): void {
  }

  getWelcomeMessage(){
    console.log(this.service.executeHelloWorldBeanService());
    this.service.executeHelloWorldBeanService().subscribe(
      response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error)
    );
    this.service.executeHelloWorldBeanService().subscribe(
      response => console.log("rM :"+response.message)
    );
    
    console.log("last line of get Welcome Messge")
  }
  handleErrorResponse(error: any): void {
    error = 'Internal Server error';
    this.welcomeErrorMessageFromService = error;
  }

  handleSuccessfulResponse(response: HelloWorld){

    this.welcomeMessageFromService = response.message;
    // console.log(response);
    // console.log(response.message);
  }

  // getUserDetails(){
  //   this.router.navigate(['userDetails'])
  // }

  // uploadUserAccountDetails(){
  //   this.router.navigate(['uploaduserAccountInfo'])
  // }

  // getUserAccountDetails(){
  //   this.router.navigate(['userAccountDetails'])
  // }

}
