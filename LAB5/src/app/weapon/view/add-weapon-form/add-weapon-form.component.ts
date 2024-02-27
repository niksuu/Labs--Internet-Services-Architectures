import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {WeaponServiceService} from "../../service/weapon-service.service";
import {Weapon} from "../../model/weapon.model";
@Component({
  selector: 'app-add-weapon-form',
  templateUrl: './add-weapon-form.component.html',
  styleUrl: './add-weapon-form.component.css'
})
export class AddWeaponFormComponent {
  weaponForm: FormGroup;
  professionId: string | undefined;
  constructor(private fb: FormBuilder,private router: Router, private weaponService: WeaponServiceService, private route: ActivatedRoute) {
    this.professionId = this.route.snapshot.params['id'];
    this.weaponForm = this.fb.group({
      name: ['', [Validators.required]],
      damage: ['', [Validators.required]],
    });
  }
  addWeapon() {
    if (this.weaponForm.valid) {
      if (this.professionId){
        const newWeapon: Weapon = {
          id: '',
          name: this.weaponForm.value.name,
          damage: this.weaponForm.value.damage,
          profession: this.professionId,
        };
        console.log(newWeapon)
        this.weaponService.addWeapon(newWeapon).subscribe(response => {
          this.router.navigate(['/professions', this.professionId]);
        });
      }
    }
  }
}
