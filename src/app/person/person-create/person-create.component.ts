import { Component } from '@angular/core';
import { person } from '../../models/person.model';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-person-create',
  templateUrl: './person-create.component.html',
  styleUrl: './person-create.component.scss'
})
export class PersonCreateComponent {
  onSubmit (personForm: NgForm) {
    console.log(personForm)
  }

}
