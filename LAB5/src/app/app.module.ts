import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NavComponent } from './component/nav/nav.component';
import { NgbModule  } from '@ng-bootstrap/ng-bootstrap';
import { ProfessionsListComponent } from './profession/view/professions-list/professions-list.component';
import { ProfessionEditComponent } from './profession/view/profession-edit/profession-edit.component';
import { ProfessionDetailsComponent } from './profession/view/profession-details/profession-details.component';
import { ProfessionAddFormComponent } from './profession/view/profession-add-form/profession-add-form.component';
import { AddWeaponFormComponent } from './weapon/view/add-weapon-form/add-weapon-form.component';

@NgModule({

  declarations: [
    AppComponent,
    NavComponent,
    ProfessionsListComponent,
    ProfessionEditComponent,
    ProfessionDetailsComponent,
    ProfessionAddFormComponent,
    AddWeaponFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
