import { Component, OnInit } from '@angular/core';
import { ProfessionsServiceService } from '../../service/professions-service.service';
import { Profession } from '../../model/profession.model';

@Component({
  selector: 'app-professions-list',
  templateUrl: './professions-list.component.html',
  styleUrls: ['./professions-list.component.css']
})
export class ProfessionsListComponent implements OnInit {
  professions: Profession[] | undefined;

  constructor(private professionsService: ProfessionsServiceService) {}

  ngOnInit(): void {
    this.loadProfessions();
  }

  loadProfessions(): void {
    this.professionsService.getProfessions().subscribe((data: any) => {
      this.professions = data.professions.map((profession: any) => {
        return new Profession(
          profession.id,
          profession.name,
          profession.baseArmor
        );
      });
      console.log('Otrzymane dane:', this.professions);
    });
  }

  deleteProfession(id: string): void {
    this.professionsService.deleteProfession(id).subscribe(() => {
      this.loadProfessions();
    });
  }

}
