import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserAccountDetails } from '../../list-user-account-details/list-user-account-details.component';
import { API_URL } from 'src/app/app.constants';

export  class MessageResponse{
  constructor(
    public successCount : number,
    public message : string
    ){}
}

@Injectable({
  providedIn: 'root'
})
export class UserAccountDetailsDataService {

  constructor(private http:HttpClient) { }

  saveAllUserAccountDetailsBeanService(userAccountDetails : UserAccountDetails[]){
    return this.http.post<UserAccountDetails[]>(`${API_URL}/saveAllUserAccountDetails`, userAccountDetails);
  }

  getUserAccountDetailsBeanService(){
    return this.http.get<UserAccountDetails[]>(`${API_URL}/getUserAccountDetails`);
  }

  getUserAccountDetailsByIdBeanService(userAccountNo: number){
    return this.http.get<UserAccountDetails>(`${API_URL}/getUserAccountDetailsById/${userAccountNo}`);
  }

  deleteUserAccountDetailsByIdBeanService(userAccountNo: number){
    return this.http.delete<UserAccountDetails>(`http://localhost:8080/deleteUserAccountDetailsById/${userAccountNo}`);
  }

  updateUserAccountDetailsByIdBeanService(userAccountNo: number, userAccountDetails : UserAccountDetails){
    return this.http.put<UserAccountDetails>(`${API_URL}/updateUserAccountDetailsById/${userAccountNo}`, userAccountDetails);
  }

  returnStoredAccountCount(){
    return this.http.get<MessageResponse>(`${API_URL}/returnStoredAccountCount`);
  }
}
