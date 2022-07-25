/**
 * this is where the logic for our API methods will go. 
 * need to implement the components for each of those methods
*/

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class WarehouseApiService {

  http :HttpClient;
  baseUrl :string = environment.apiUrl+"/warehouses/";
  
  constructor(http :HttpClient) {
    // constructor injection
    this.http = http;
   }

  findAll() :Observable<any> {
    return this.http.get(this.baseUrl);
  }

  findById(id :number) :Observable<any> {
    return this.http.get(this.baseUrl + id);
  }

  /**
   * This function takes a string as an argument and returns an Observable of type any
   * @param {string} state - The state you want to search for.
   * @returns Observable<any>
   */
  findByState(state :string) :Observable<any> {
    return this.http.get(this.baseUrl + "state/" + state);
  }

  /**
   * It takes a warehouse object as a parameter and returns an observable of type any
   * @param {any} warehouse - any - This is the data that we are sending to the server.
   * @returns The observable is being returned.
   */
  save(warehouse :any) :Observable<any> {
    // return this.http.post(this.baseUrl, warehouse);
    return this.http.post(`${this.baseUrl}`+'save-warehouse/', warehouse);
  }

  update(warehouse :any) :Observable<any> {
    // return this.http.put(this.baseUrl + "/" + warehouse.id, warehouse);
    return this.http.post(`${this.baseUrl}/update-warehouse/${warehouse.id}`, warehouse);
  }

  delete(warehouse :any) :Observable<any> {
    return this.http.delete(this.baseUrl + "/delete/" + warehouse);
  }

  deleteById(id :number) :Observable<any> {
    return this.http.delete(this.baseUrl + "delete/" + id);
  }
}
