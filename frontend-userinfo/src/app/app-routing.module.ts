import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { ErrorComponent } from './error/error.component';
import { ListUserDetailsComponent } from './list-user-details/list-user-details.component';
import { ListUserAccountDetailsComponent } from './list-user-account-details/list-user-account-details.component';
import { UploadUserAccountInfoComponent } from './upload-user-account-info/upload-user-account-info.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UserAccountDetailsComponent } from './user-account-details/user-account-details.component';

const routes: Routes = [
  {path:'', component: WelcomeComponent}, //UserDetailsListComponent
  {path:'welcome', component: WelcomeComponent},
  {path:'userDetails', component: ListUserDetailsComponent}, //UserDetailsListComponent
  {path:'userDetails/:userId', component: UserDetailsComponent}, 
  {path:'addUserDetails', component: UserDetailsComponent},
  {path:'uploadUserAccountInfo', component: UploadUserAccountInfoComponent}, 
  // {path:'addUserAccountDetails', component: UserAccountDetailsComponent},
  {path:'userAccountDetails', component: ListUserAccountDetailsComponent}, //UserAccountDetailsListComponent
  {path:'userAccountDetails/:userAccountNo', component: UserAccountDetailsComponent}, 
  {path:'**', component: ErrorComponent} //UserDetailsListComponent
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
