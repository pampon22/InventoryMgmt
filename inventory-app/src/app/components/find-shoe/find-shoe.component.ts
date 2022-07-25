import { Component, OnInit } from '@angular/core';
import { ShoeApiService } from 'src/app/services/shoe-api.service';

@Component({
  selector: 'app-find-shoe',
  templateUrl: './find-shoe.component.html',
  styleUrls: ['./find-shoe.component.css']
})
export class FindShoeComponent implements OnInit {

  service :ShoeApiService;
  searchId :number;
  shoe :any;

  constructor(service :ShoeApiService) {
    this.service = service;
    this.searchId = 0;
   }

  ngOnInit(): void {}

  onChange() :void {
    this.service.findById(this.searchId).subscribe(value => {
      this.shoe = value;
    });
  }

}
