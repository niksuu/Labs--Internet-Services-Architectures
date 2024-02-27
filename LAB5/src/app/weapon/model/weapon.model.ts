export class Weapon{
    id: string;
    name: string;
    damage: number;
    profession: string;

    constructor(id: string, name: string, damage: number, professionId: string) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.profession = professionId;
    }
}
