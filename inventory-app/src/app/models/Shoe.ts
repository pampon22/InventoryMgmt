/** Shoe that class that represents the shoe entity from the database.
 * we mock it to look like the shoe model from our java class.
 */

export class Shoe {
    id: number;
    name: string;
    size: number;
    color: string;
    brand: string;
    
    constructor(id = 0, name = "", size = 0, color = "", brand = "") {
        this.id = id;
        this.name = name;
        this.size = size;
        this.color = color;
        this.brand = brand;
    }
}