import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ErrorComponent } from './error/error.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { ListUserDetailsComponent } from './list-user-details/list-user-details.component';
import { ListUserAccountDetailsComponent } from './list-user-account-details/list-user-account-details.component';
import { UploadUserAccountInfoComponent } from './upload-user-account-info/upload-user-account-info.component';
import { MenuComponent } from './menu/menu.component';
import { FooterComponent } from './footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UserAccountDetailsComponent } from './user-account-details/user-account-details.component';

@NgModule({
  declarations: [
    AppComponent,
    ErrorComponent,
    WelcomeComponent,
    ListUserDetailsComponent,
    ListUserAccountDetailsComponent,
    UploadUserAccountInfoComponent,
    MenuComponent,
    FooterComponent,
    UserDetailsComponent,
    UserAccountDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
