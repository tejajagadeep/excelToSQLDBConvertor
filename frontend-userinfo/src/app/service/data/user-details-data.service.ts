import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserDetails } from '../../list-user-details/list-user-details.component';
import { API_URL } from 'src/app/app.constants';

export  class HelloWorld{
  constructor(public message : string){}
}

@Injectable({
  providedIn: 'root'
})
export class UserDetailsDataService {

  constructor(private http:HttpClient) { }

  saveUserDetailsBeanService(userDetails : UserDetails){
    return this.http.post<UserDetails>(`${API_URL}/saveUserDetails`, userDetails);
  }

  getUserDetailsBeanService(){
    return this.http.get<UserDetails[]>(`${API_URL}/getUserDetails`);
  }

  getUserDetailsByIdBeanService(userId: number){
    return this.http.get<UserDetails>(`${API_URL}/getUserDetailsById/${userId}`);
  }

  deleteUserDetailsByIdBeanService(userId: number){
    return this.http.delete<UserDetails>(`http://localhost:8080/deleteUserDetailsById/${userId}`);
  }

  updateUserDetailsByIdBeanService(userId: number, userDetails : UserDetails){
    return this.http.put<UserDetails>(`${API_URL}/updateUserDetailsById/${userId}`, userDetails);
  }

}
