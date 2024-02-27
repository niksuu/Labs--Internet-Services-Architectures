import { Component } from '@angular/core';
import { Profession } from '../../model/profession.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ProfessionsServiceService } from '../../service/professions-service.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-profession-add-form',
  templateUrl: './profession-add-form.component.html',
  styleUrl: './profession-add-form.component.css'
})
export class ProfessionAddFormComponent {
  professionForm: FormGroup;

  constructor(private fb: FormBuilder,private router: Router, private professionService: ProfessionsServiceService) {
    this.professionForm = this.fb.group({
      name: ['', [Validators.required]],
      baseArmor: ['', [Validators.required, Validators.min(0)]],
    });
  }
  addProfession() {
    if (this.professionForm.valid) {
      const newProfession: Profession = {
        id: '',  // Automatycznie generowane w serwisie
        name: this.professionForm.value.name,
        baseArmor: this.professionForm.value.baseArmor,
      };

      this.professionService.addProfession(newProfession).subscribe(response => {
        this.router.navigate(['/professions']);
      });
    }
  }
}
