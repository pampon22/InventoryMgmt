import { Component, OnInit } from '@angular/core';
import { Shoe } from 'src/app/models/shoe.model';
import { ShoeApiService } from 'src/app/services/shoe-api.service';

@Component({
  selector: 'app-shoe-form',
  templateUrl: './shoe-form.component.html',
  styleUrls: ['./shoe-form.component.css']
})
export class ShoeFormComponent implements OnInit {
  shoe: Shoe = new Shoe();
  submitted : boolean = false;

  constructor(private service: ShoeApiService) { }

  ngOnInit(): void {
  }

  saveShoe(): void {
    const data = this.shoe;
    this.service.save(data).subscribe({
      next: (resp) => {
        console.log(resp);
        this.submitted = true;
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  newShoe(): void {
    this.submitted = false;
    this.shoe = new Shoe();
    // console.log(this.shoe)
  }

}
