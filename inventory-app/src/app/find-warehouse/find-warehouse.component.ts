import { Component, OnInit } from '@angular/core';
import { WarehouseApiService } from '../services/warehouse-api.service';

@Component({
  selector: 'app-find-warehouse',
  templateUrl: './find-warehouse.component.html',
  styleUrls: ['./find-warehouse.component.css']
})
export class FindWarehouseComponent implements OnInit {

  service :WarehouseApiService;
  searchId :number;
  warehouse :any;

  constructor(service :WarehouseApiService) {
    this.service = service;
    this.searchId = 0;
   }

  ngOnInit(): void {
    this.service.findById(this.searchId).subscribe(data => {
      this.warehouse = data;
    }
  )};
  
  onChange() {
    this.service.findById(this.searchId).subscribe(data => {
      this.warehouse = data;
    }
  )};

}
