import { Component, OnInit } from '@angular/core';
import { ProfessionsServiceService } from '../../service/professions-service.service';
import { Profession } from '../../model/profession.model';
import  {WeaponServiceService } from "../../../weapon/service/weapon-service.service";
import {Weapon} from "../../../weapon/model/weapon.model";
import {ActivatedRoute, Router} from "@angular/router";
@Component({
  selector: 'app-profession-details',
  templateUrl: './profession-details.component.html',
  styleUrl: './profession-details.component.css'
})
export class ProfessionDetailsComponent  implements OnInit {
  professionId: string | undefined;
  profession: Profession | undefined;
  weapons: Weapon[] = [];

  constructor(
      private route: ActivatedRoute,
      private router: Router,
      private professionService: ProfessionsServiceService,
      private weaponService: WeaponServiceService
  ) {}

  ngOnInit(): void {
    this.professionId = this.route.snapshot.params['id'];

    if (this.professionId) {
      this.professionService.getProfessionById(this.professionId).subscribe((profession: Profession) => {
        this.profession = profession;
        this.getWeaponsByProfessionId(this.professionId!);
      });
    }
  }

  getWeaponsByProfessionId(id: string) {
    this.weaponService.getWeaponsByProfessionId(id).subscribe((response: any) => {
      this.weapons = response.weapons;
      console.log(this.weapons);
    });
  }


  deleteWeapon(id: string) {
    this.weaponService.deleteWeapon(id).subscribe((response: any) => {
      this.getWeaponsByProfessionId(this.professionId!);
    });
  }

  protected readonly Profession = Profession;
}
