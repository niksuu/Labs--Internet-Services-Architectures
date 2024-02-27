export class Profession {
  id: string;
  name: string;
  baseArmor: number;

  constructor(id: string, name: string, baseArmor:number) {
    this.id = id;
    this.name = name;
    this.baseArmor=baseArmor;
  }
}
