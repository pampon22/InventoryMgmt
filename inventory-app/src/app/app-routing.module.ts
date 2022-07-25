import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';

const routes: Routes = [
  // {path : '**', component : PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


// import { NgModule } from '@angular/core';
// import { RouterModule, Routes } from '@angular/router';
// import { AddShoeComponent } from './components/add-shoe/add-shoe.component';
// import { ShoeListComponent } from './components/shoe-list/shoe-list.component';
// import { FindShoeComponent } from './components/find-shoe/find-shoe.component';
// import { UpdateShoeComponent } from './components/update-shoe/update-shoe.component';
// import { DeleteShoeComponent } from './components/delete-shoe/delete-shoe.component';
// import { AddWarehouseComponent } from './components/add-warehouse/add-warehouse.component';
// import { WarehouseListComponent } from './components/warehouse-list/warehouse-list.component';
// import { FindWarehouseComponent } from './components/find-warehouse/find-warehouse.component';
// import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';


// const routes: Routes = [
//   { path : '', redirectTo : '/shoes', pathMatch : 'full'},
//   { path : '/shoes', component : ShoeListComponent},
//   { path : '/shoes/add', component : AddShoeComponent},
//   { path : '/shoes/:id', component : FindShoeComponent},
//   { path : '/shoes/update/:id', component : UpdateShoeComponent},
//   { path : '/shoes/delete/:id', component : DeleteShoeComponent},
//   { path : '/warehouses', component : WarehouseListComponent},
//   { path : '/warehouses/add', component : AddWarehouseComponent},
//   { path : '/warehouses/:id', component : FindWarehouseComponent},
//   { path : '/**', component : PageNotFoundComponent}

// ];

// @NgModule({
//   imports: [RouterModule.forRoot(routes)],
//   exports: [RouterModule]
// })
// export class AppRoutingModule { }
