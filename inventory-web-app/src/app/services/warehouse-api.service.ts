import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Warehouse } from '../models/warehouse.model';


const baseURL = 'http://localhost:8080/warehouseManager/warehouses/';

@Injectable({
  providedIn: 'root'
})
export class WarehouseApiService {

  http :HttpClient;
  
  constructor(http :HttpClient) {
    // constructor injection
    this.http = http;
   }

  findAll() :Observable<any> {
    return this.http.get<Warehouse[]>(baseURL);
  }

  findById(id :number) :Observable<any> {
    return this.http.get(baseURL + "/" + id);
  }

  /**
   * This function takes a string as an argument and returns an Observable of type any
   * @param {string} state - The state you want to search for.
   * @returns Observable<any>
   */
  findByState(state :string) :Observable<any> {
    return this.http.get(baseURL + "state/" + state);
  }

  /**
   * It takes a warehouse object as a parameter and returns an observable of type any
   * @param {any} warehouse - any - This is the data that we are sending to the server.
   * @returns The observable is being returned.
   */
  save(warehouse :any) :Observable<any> {
    return this.http.post(baseURL + '/', warehouse);
  }

  update(warehouse :any) :Observable<any> {
    // return this.http.put(this.baseUrl + "/" + warehouse.id, warehouse);
    return this.http.put(baseURL + warehouse.id, warehouse);
  }

  deleteById(id :number) :Observable<any> {
    return this.http.delete(baseURL + id);
  }
}
