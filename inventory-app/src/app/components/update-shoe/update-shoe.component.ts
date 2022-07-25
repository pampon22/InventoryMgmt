import { Component, OnInit } from '@angular/core';
import { ShoeApiService } from 'src/app/services/shoe-api.service';

@Component({
  selector: 'app-update-shoe',
  templateUrl: './update-shoe.component.html',
  styleUrls: ['./update-shoe.component.css']
})
export class UpdateShoeComponent implements OnInit {

  service :ShoeApiService;
  shoe :any;

  constructor(service :ShoeApiService) {
    this.service = service;
    
   }

  ngOnInit(): void {
    };
  
  update(shoe :any) :void {
    this.service.update(shoe).subscribe(data => {
      this.shoe = data;
    });
  }
  
}
