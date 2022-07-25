import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Shoe } from '../models/shoe.model';

const baseURL = 'http://localhost:8080/warehouseManager';

@Injectable({
  providedIn: 'root'
})
export class ShoeApiService {

  constructor(private http: HttpClient) { }
    findAll(): Observable<Shoe[]> {
      return this.http.get<Shoe[]>(baseURL + '/shoes');
    }

    findById(id: number): Observable<Shoe> {
      console.log(this.http.get<Shoe>(baseURL + '/shoes/' + id));
      return this.http.get<Shoe>(baseURL + '/shoes/' + id);
    }
    
    findShoeLike(name: string): Observable<Shoe[]> {
      return this.http.get<Shoe[]>(baseURL + '/shoes/' + name);
    }
    
    save(shoe: Shoe): Observable<Shoe> {
      console.log(shoe);
      return this.http.post<Shoe>(baseURL + '/shoes', shoe);
    }

    update(shoe: Shoe): Observable<Shoe> {
      return this.http.put<Shoe>(baseURL + '/shoes/' + shoe.id, shoe);
    }

    delete(id: number): Observable<Shoe> {
      return this.http.delete<Shoe>(baseURL + '/shoes/' + id);
    }
}
