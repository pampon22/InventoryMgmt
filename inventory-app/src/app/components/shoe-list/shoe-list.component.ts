import { Component, OnInit } from '@angular/core';
import { ShoeApiService } from 'src/app/services/shoe-api.service';
import { Shoe } from 'src/app/models/Shoe';

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
    this.refreshData();
    setInterval(() => {
      this.refreshData(); 
    }, 1000);
  }

  refreshData() :void {
    this.service.findAll().subscribe(data => {
      this.shoes = data;
      console.log('shoe data refreshed')
    });
  }

}
