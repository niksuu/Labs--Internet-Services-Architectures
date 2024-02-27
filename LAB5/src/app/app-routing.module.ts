import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProfessionsListComponent} from "./profession/view/professions-list/professions-list.component";
import {ProfessionAddFormComponent} from "./profession/view/profession-add-form/profession-add-form.component";
import {AppComponent} from "./app.component";
import {ProfessionEditComponent} from "./profession/view/profession-edit/profession-edit.component";
import {ProfessionDetailsComponent} from "./profession/view/profession-details/profession-details.component";
import {AddWeaponFormComponent} from "./weapon/view/add-weapon-form/add-weapon-form.component";


const routes: Routes = [
  { path: 'professions', component: ProfessionsListComponent },
  { path: 'add-profession', component: ProfessionAddFormComponent },
  { path: 'professions/:id/edit', component: ProfessionEditComponent },
  { path: 'professions/:id', component: ProfessionDetailsComponent },
  { path: 'professions/:id/add-weapon', component: AddWeaponFormComponent },
  { path: '', redirectTo: '', pathMatch: 'full' }, // Domyślna trasa
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
