import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Shoe } from 'src/app/models/shoe.model';
import { ShoeApiService } from 'src/app/services/shoe-api.service';

@Component({
  selector: 'app-shoe-details',
  templateUrl: './shoe-details.component.html',
  styleUrls: ['./shoe-details.component.css']
})

export class ShoeDetailsComponent implements OnInit {
  
  /**
   * @Input() decorator that allows us to pass data from the parent component to the child component.
   */
  @Input() viewMode: boolean = false;
  @Input() currentShoe: Shoe = new Shoe();
  service : ShoeApiService;
  route : ActivatedRoute;
  router : Router;

  constructor(service: ShoeApiService, route: ActivatedRoute, router: Router) {
    this.service = service;
    this.route = route;
    this.router = router;
  }

  ngOnInit(): void {
    if (!this.viewMode) {
      this.getShoe(this.route.snapshot.params['id']);
    }
  }

  getShoe(id: number): void {
    this.service.findById(id).subscribe({
      next: (resp) => {
        console.log(resp);
        this.currentShoe = resp;
      }, error: (err) => {
        console.log(err);
      }
    });
  }

  updateShoe(): void {
    this.service.update(this.currentShoe).subscribe({
      next: (resp) => {
        console.log(resp);
        this.router.navigate(['/shoes']);
      }, error: (err) => {
        console.log(err);
      }
    });
  }

  deleteShoe(): void {
    this.service.delete(this.currentShoe.id).subscribe({
      next: (resp) => {
        console.log(resp);
        this.router.navigate(['/shoes']);
      }, error: (err) => {
        console.log(err);
      }
    });
  }

}
