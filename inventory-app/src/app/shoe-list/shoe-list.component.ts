import { Component, OnInit } from '@angular/core';
import { ShoeApiService } from '../services/shoe-api.service';
import { Shoe } from '../models/Shoe';

@Component({
  selector: 'app-shoe-list',
  templateUrl: './shoe-list.component.html',
  styleUrls: ['./shoe-list.component.css']
})
export class ShoeListComponent implements OnInit {

  shoes : Array<Shoe> = [];

  constructor(private service :ShoeApiService) {
    this.service = service;
   }

  ngOnInit(): void {
    this.service.findAll().subscribe(data => {
      this.shoes = data;
    });
  }

}
