import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShoeListComponent } from './components/shoe-list/shoe-list.component';
import { ShoeDetailsComponent } from './components/shoe-details/shoe-details.component';
import { ShoeFormComponent } from './components/shoe-form/shoe-form.component';

const routes: Routes = [
  { path: '', redirectTo: 'shoes', pathMatch: 'full' },
  { path: 'shoes', component: ShoeListComponent },
  { path: 'shoes/:id', component: ShoeDetailsComponent },
  { path: 'add', component: ShoeFormComponent },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
