import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Profession } from '../../model/profession.model';
import { ProfessionsServiceService } from '../../service/professions-service.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-profession-edit',
  templateUrl: './profession-edit.component.html',
  styleUrls: ['./profession-edit.component.css']
})
export class ProfessionEditComponent implements OnInit {
  professionForm!: FormGroup;
  professionId!: string;
  profession!: Profession;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private professionService: ProfessionsServiceService
  ) {}

  ngOnInit(): void {
    this.professionId = this.route.snapshot.params['id'];

    this.professionService.getProfessionById(this.professionId).subscribe((profession: Profession) => {
      this.profession = profession;

      // profession-edit.component.ts
      this.professionForm = this.fb.group({
        id: [this.profession ? this.profession.id : '', Validators.required],
        name: [this.profession ? this.profession.name : '', Validators.required],
        baseArmor: [this.profession ? this.profession.baseArmor : '', [Validators.required, Validators.min(0)]],
      });
    });
  }

  updateProfession() {
    if (this.professionForm.valid) {
      const updatedProfession: Profession = {
        id: this.professionForm.value.id,
        name: this.professionForm.value.name,
        baseArmor: this.professionForm.value.baseArmor,
      };

      this.professionService.updateProfession(updatedProfession).subscribe(response => {
        this.router.navigate(['/professions']);
      });
    }
  }
}
