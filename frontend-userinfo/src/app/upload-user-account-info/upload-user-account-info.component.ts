import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import * as XLSX from 'xlsx';
import { UserAccountDetails } from '../list-user-account-details/list-user-account-details.component';
import { UserDetails } from '../list-user-details/list-user-details.component';
import { MessageResponse, UserAccountDetailsDataService } from '../service/data/user-account-details-data.service';
import { UserDetailsDataService } from '../service/data/user-details-data.service';

@Component({
  selector: 'app-upload-user-account-info',
  templateUrl: './upload-user-account-info.component.html',
  styleUrls: ['./upload-user-account-info.component.css']
})
export class UploadUserAccountInfoComponent implements OnInit {

  a = document.getElementById("uploadTable");
  
  userAccountDetails!: UserAccountDetails;
  successMessage!: string;
  failureMessage!: string;
  successCount=0;
  failureCount=0;

  ExcelData : any;
  tCount!: number;

  constructor( private userAccountDetailsDataService : UserAccountDetailsDataService, private router : Router, private route : ActivatedRoute) { }

  ngOnInit(): void {
  }

  ReadExcel(event : any){
    let file = event.target.files[0];

    let fileReader = new FileReader();
    fileReader.readAsBinaryString(file);

    fileReader.onload = (e) => {
      var workBook = XLSX.read(fileReader.result,{type:'binary'});
      var sheetNames = workBook.SheetNames;
      this.ExcelData = XLSX.utils.sheet_to_json(workBook.Sheets[sheetNames[0]])
    }

  }

  saveAllUserAccountDetails(){

    this.userAccountDetailsDataService.saveAllUserAccountDetailsBeanService(this.ExcelData).subscribe(
      response => {
        this.ExcelData = response,
        this.userAccountDetails.accountCreationDate = new Date(this.ExcelData.accountCreationDate);
      }
      
    );

    this.returnMessage();
    
  }

  returnMessage(){

    this.userAccountDetailsDataService.returnStoredAccountCount().subscribe(
      response =>  {
        this.successMessage=response.message
        this.successCount=response.successCount
        console.log("this.successCount : "+this.successCount)
        this.failureCount = this.ExcelData.length - this.successCount;
        console.log("this.failureCount : "+this.failureCount)
        this.failureMessage=`${this.failureCount} Records are not stored.`
      }
      
    );

  }

 
}

