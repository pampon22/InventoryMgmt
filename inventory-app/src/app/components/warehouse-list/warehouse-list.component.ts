import { Component, OnInit } from '@angular/core';
import { WarehouseApiService } from 'src/app/services/warehouse-api.service';
import { Warehouse } from 'src/app/models/Warehouse';

@Component({
  selector: 'app-warehouse-list',
  templateUrl: './warehouse-list.component.html',
  styleUrls: ['./warehouse-list.component.css']
})
export class WarehouseListComponent implements OnInit {

  service :WarehouseApiService;
  warehouses :Array<Warehouse> = [];


  /**
   * The constructor function is a special function that is called when an object is created from a
   * class. used for only for property setting
   * @param {WarehouseApiService} service - The service that will be used to make the API calls.
   */
  constructor(service :WarehouseApiService) {
    this.service = service;
   }

  
  /**
   * The function is called when the component is initialized. It calls the service's findAll()
   * function, which returns an Observable. The subscribe() function is called on the Observable, which
   * takes a callback function as a parameter. The callback function takes the data returned by the
   * Observable as a parameter. The data is then assigned to the warehouses variable
   */
  ngOnInit(): void {
    this.service.findAll().subscribe(data => {
      this.warehouses = data;
    });
  }

}
