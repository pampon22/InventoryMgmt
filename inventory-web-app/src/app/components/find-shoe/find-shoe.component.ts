import { Component, OnInit } from '@angular/core';
import { Shoe } from 'src/app/models/shoe.model';
import { ShoeApiService } from 'src/app/services/shoe-api.service';

@Component({
  selector: 'app-find-shoe',
  templateUrl: './find-shoe.component.html',
  styleUrls: ['./find-shoe.component.css']
})
export class FindShoeComponent implements OnInit {

  service: ShoeApiService;
  id: number;
  shoe: Shoe = new Shoe();

  constructor(service: ShoeApiService) {
    this.service = service;
    this.id = 0;
   }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.service.findById(this.id).subscribe({
      next: (resp) => {
        console.log(resp);
        this.shoe = resp;
      }, error: (err) => {
        console.log(err);
      }
    });
  }

}