import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PersonComponent } from './person/person.component';
import { PersonCreateComponent } from './person/person-create/person-create.component';
import { PersonDeleteComponent } from './person/person-delete/person-delete.component';
import { PersonDetailsComponent } from './person/person-details/person-details.component';
import { PersonEditComponent } from './person/person-edit/person-edit.component';
import { HttpClient } from '@angular/common/http';



@NgModule({
  declarations: [
    AppComponent,
    PersonComponent,
    PersonCreateComponent,
    PersonDeleteComponent,
    PersonDetailsComponent,
    PersonEditComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
