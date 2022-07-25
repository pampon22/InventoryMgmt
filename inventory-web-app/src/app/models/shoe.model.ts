/** Shoe that class that represents the shoe entity from the database.
 * we mock it to look like the shoe model from our java class.
*/

 export class Shoe {
    id: number;
    name: string;
    color: string;
    brand: string;
    quantity : number;
    location: number;
    
    constructor(id = 0, name = "", color = "", brand = "", quantity = 0, location = 0) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.brand = brand;
        this.quantity = quantity;
        this.location = location;
    }
}