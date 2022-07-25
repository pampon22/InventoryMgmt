import { Component, OnInit } from '@angular/core';
import { ShoeApiService } from 'src/app/services/shoe-api.service';

@Component({
  selector: 'app-delete-shoe',
  templateUrl: './delete-shoe.component.html',
  styleUrls: ['./delete-shoe.component.css']
})
export class DeleteShoeComponent implements OnInit {

  service :ShoeApiService;
  shoe :any;
  submitted :boolean = false;

  constructor(service :ShoeApiService) {
    this.service = service;
    
   }

  ngOnInit(): void {
    this.submitted = false;
    };
  
  delete(shoe :any) :void {
    this.service.deleteById(shoe.id).subscribe(data => {
      this.shoe = data;
    });
  }
}
