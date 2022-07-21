/** Warehouse that class that represents the warehouse entity from ou database.
 * we mock it to look like the warehouse model from our java class.
*/
// we need to export it so that we can use it in other files.
export class Warehouse {
    id: number;
    state: string;
    capacity: number;
    
    constructor(id = 0, state = "", capacity = 0) {
        this.id = id;
        this.state = state;
        this.capacity = capacity;
    }
}