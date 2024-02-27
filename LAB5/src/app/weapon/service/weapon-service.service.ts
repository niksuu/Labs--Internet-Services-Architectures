import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Weapon} from "../model/weapon.model";
import {v4 as uuidv4} from "uuid";
import {Profession} from "../../profession/model/profession.model";

@Injectable({
    providedIn: 'root'
})
export class WeaponServiceService {
    private readonly apiUrl = '/api/weapons';
    private readonly apiByIdUrl = '/api/weapons/{id}';
    private readonly apiByIdUrlWeapons = '/api/professions/{id}/weapons';

    constructor(private http: HttpClient) {
    }

    getWeaponsByProfessionId(id: string): Observable<any[]> {
        const url = this.apiByIdUrlWeapons.replace('{id}', id);
        console.log(url);
        return this.http.get<any[]>(url);
    }

    deleteWeapon(id: string) {
        const url = this.apiByIdUrl.replace('{id}', id);
        return this.http.delete(url);
    }

    addWeapon(weapon: Weapon): Observable<any> {
        weapon.id = uuidv4();
        return this.http.put<any>(`${this.apiUrl}/${weapon.id}`, weapon);
    }

    updateWeapon(weapon: Weapon): Observable<any> {
        return this.http.put<any>(`${this.apiUrl}/${weapon.id}`, weapon);
    }

    getWeaponById(id: string): Observable<Weapon> {
        const url = this.apiByIdUrl.replace('{id}', id);
        return this.http.get<Weapon>(url);
    }
}
