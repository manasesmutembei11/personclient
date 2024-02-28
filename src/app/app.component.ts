import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { person } from './models/person.model';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {

  person: person = { id: 0, firstName: '', lastName: '', email: '', phone: '', country: '', dateOfBirth: new Date(), status:0, paymentNumber: ''   };

  constructor(private http: HttpClient) { } // Inject HttpClient

  onSubmit(form: NgForm) {
    if (form.valid) {
      this.person = form.value;

      // Send HTTP POST request to ASP.NET Core backend
      this.http.post('https://localhost:7240/People/Create', this.person).subscribe(response => {
        console.log('Post created successfully:', response);
        // Reset the form
        form.resetForm();
      }, error => {
        console.error('Error creating post:', error);
      });
    } else {
      console.log('Form is invalid');
    }
  }



}
