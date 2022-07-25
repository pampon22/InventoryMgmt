import { Component, OnInit } from '@angular/core';
import { ShoeApiService } from 'src/app/services/shoe-api.service';


@Component({
  selector: 'app-add-shoe',
  templateUrl: './add-shoe.component.html',
  styleUrls: ['./add-shoe.component.css']
})
export class AddShoeComponent implements OnInit {

  service :ShoeApiService;
  shoe :any;
  submitted :boolean = false;

  constructor(service :ShoeApiService) {
    this.service = service;
    
   }

  ngOnInit(): void {
    this.submitted = false;
    };
  
  addShoe(shoe :any) :void {
    this.service.save(shoe).subscribe(data => {
      this.shoe = data;
    });
  }
}
