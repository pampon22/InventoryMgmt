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
  
  constructor(http :HttpClient) {
    // constructor injection
    this.http = http;
   }

  findAll() :Observable<any> {
    return this.http.get(environment.apiUrl);
  }

  findById(id :number) :Observable<any> {
    return this.http.get(environment.apiUrl + "/" + id);
  }

  findByState(state :string) :Observable<any> {
    return this.http.get(environment.apiUrl + "/state/" + state);
  }

  save(warehouse :any) :Observable<any> {
    return this.http.post(environment.apiUrl, warehouse);
  }

  update(warehouse :any) :Observable<any> {
    return this.http.put(environment.apiUrl + "/" + warehouse.id, warehouse);
  }

  delete(warehouse :any) :Observable<any> {
    return this.http.delete(environment.apiUrl + "/" + warehouse);
  }

  deleteById(id :number) :Observable<any> {
    return this.http.delete(environment.apiUrl + "/" + id);
  }
}
