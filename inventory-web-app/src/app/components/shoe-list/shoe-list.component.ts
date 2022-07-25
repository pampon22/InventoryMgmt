import { Component, OnInit } from '@angular/core';
import { Shoe } from 'src/app/models/shoe.model';
import { ShoeApiService } from 'src/app/services/shoe-api.service';

@Component({
  selector: 'app-shoe-list',
  templateUrl: './shoe-list.component.html',
  styleUrls: ['./shoe-list.component.css']
})
export class ShoeListComponent implements OnInit {
  shoes: Array<Shoe> = [];
  currentShoe: Shoe = new Shoe();
  currentIndex: number = -1;
  shoe: any;

  constructor(private service: ShoeApiService) { }

  ngOnInit(): void {
    this.retrieveShoes();
    setInterval(() => {
      this.retrieveShoes();
    }, 6000);
    // console.log(this.shoes)
  }

  retrieveShoes(): void {
    this.service.findAll().subscribe({
      next: (resp) => {
        console.log(resp);
        this.shoes = resp;
      }, error: (err) => {
        console.log(err);
      }
    });
  }

  refreshData(): void {
    this.retrieveShoes();
    this.currentShoe = {} as Shoe;
    this.currentIndex = -1;
  }

  setActiveShoe(shoe: Shoe, index: number): void {
    this.currentShoe = shoe;
    this.currentIndex = index;
  }

  deleteShoe(id: number): void {
    this.service.delete(id).subscribe({
      next: (resp) => {
        console.log(resp);
        this.refreshData();
      }, error: (err) => {
        console.log(err);
      }
    });
  }

  searchShoe(id: number): void {
    this.service.findById(id).subscribe({
      next: (resp) => {
        console.log(resp);
        this.shoe = resp;
      }, error: (err) => {
        console.log(err);
      }
    });
  }

}
