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
  creationMessage : string = "";
  creationSuccess: boolean = false;

  constructor(private service: ShoeApiService) { }

  ngOnInit(): void {
  }

  saveShoe(): void {
    const data = this.shoe;
    this.service.save(data).subscribe({
      next: (resp) => {
        console.log(resp);
        this.submitted = true;
        this.creationMessage = "Shoe created successfully";
        this.creationSuccess = true;
      },
      error: (err) => {
        console.log(err);
        this.creationMessage = "Error creating shoe";
      }
    });
  }

  newShoe(): void {
    this.submitted = false;
    this.shoe = new Shoe();
    // console.log(this.shoe)
  }

}
