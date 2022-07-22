import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ShoeApiService {
  
  http :HttpClient;
  baseUrl :string = environment.apiUrl+"shoes/";
  
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
   * It takes a shoe object as a parameter and returns an observable of type any
   * @param {any} shoe - any - This is the data that we are sending to the server.
   * @returns The observable is being returned.
   */
  save(shoe :any) :Observable<any> {
    // return this.http.post(this.baseUrl, shoe);
    return this.http.post(`${this.baseUrl}`+'save-shoe/', shoe);
  }

  update(shoe :any) :Observable<any> {
    // return this.http.put(this.baseUrl + "/" + shoe.id, shoe);
    return this.http.post(`${this.baseUrl}/update-shoe/${shoe.id}`, shoe);
  }

  delete(shoe :any) :Observable<any> {
    return this.http.delete(this.baseUrl + "/" + shoe);
  }

  deleteById(id :number) :Observable<any> {
    return this.http.delete(this.baseUrl + "delete/" + id);
  }
}
