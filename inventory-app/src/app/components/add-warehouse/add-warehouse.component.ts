import { Component, OnInit } from '@angular/core';
import { WarehouseApiService } from 'src/app/services/warehouse-api.service';

@Component({
  selector: 'app-add-warehouse',
  templateUrl: './add-warehouse.component.html',
  styleUrls: ['./add-warehouse.component.css']
})
export class AddWarehouseComponent implements OnInit {

  service :WarehouseApiService;
  warehouse :any;
  submitted :boolean = false;

  constructor(service :WarehouseApiService) {
    this.service = service;
    
   }

  ngOnInit(): void {
    this.submitted = false;
    };
  
  onChange() { 

  };
}