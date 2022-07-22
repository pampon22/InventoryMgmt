import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }



// import { NgModule } from '@angular/core';
// import { RouterModule, Routes } from '@angular/router';
// import { WarehouseListComponent } from './warehouse-list/warehouse-list.component';
// import { FindWarehouseComponent } from './find-warehouse/find-warehouse.component';
// import { AddWarehouseComponent } from './add-warehouse/add-warehouse.component';

// const routes: Routes = [
//   { path: '', redirectTo: 'warehouse-list', pathMatch: 'full' },
//   { path: 'warehouse-list', component: WarehouseListComponent },
//   { path: 'find-warehouse', component: FindWarehouseComponent },
//   { path: 'add-warehouse', component: AddWarehouseComponent }
// ];

// @NgModule({
//   imports: [RouterModule.forRoot(routes)],
//   exports: [RouterModule]
// })
// export class AppRoutingModule { }
