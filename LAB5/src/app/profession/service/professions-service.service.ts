import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders  } from '@angular/common/http';
import { v4 as uuidv4 } from 'uuid';
import { Observable } from 'rxjs';
import { Profession} from "../model/profession.model";

@Injectable({
  providedIn: 'root'
})
export class ProfessionsServiceService {
  private readonly apiUrl = '/api/professions';
  private readonly apiByIdUrl = '/api/professions/{id}';

  constructor(private http: HttpClient) {}

  getProfessions(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
  getProfessionById(id: string): Observable<Profession> {
    const url = this.apiByIdUrl.replace('{id}', id);
    return this.http.get<Profession>(url);
  }

  addProfession(profession: Profession): Observable<any> {
    profession.id = uuidv4();
    return this.http.put<any>(`${this.apiUrl}/${profession.id}`, profession);
  }
  updateProfession(profession: Profession): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${profession.id}`, profession);
  }
  deleteProfession(id: string): Observable<any> {
    const url = this.apiByIdUrl.replace('{id}', id);
    return this.http.delete(url);
  }
}
