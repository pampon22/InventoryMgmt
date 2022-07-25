import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WarehouseListComponent } from 'src/app/components/warehouse-list/warehouse-list.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FindWarehouseComponent } from 'src/app/components/find-warehouse/find-warehouse.component';
import { AddWarehouseComponent } from 'src/app/components/add-warehouse/add-warehouse.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ShoeListComponent } from 'src/app/components/shoe-list/shoe-list.component';
import { ShoeApiService } from './services/shoe-api.service';
import { FindShoeComponent } from './components/find-shoe/find-shoe.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import {TableModule} from 'primeng/table';
import { AddShoeComponent } from './components/add-shoe/add-shoe.component';
import { DeleteShoeComponent } from './components/delete-shoe/delete-shoe.component';


@NgModule({
  declarations: [
    AppComponent,
    WarehouseListComponent,
    ShoeListComponent,
    FindShoeComponent,
    PageNotFoundComponent,
    NavBarComponent,
    AddShoeComponent,
    DeleteShoeComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    TableModule
  ],
  providers: [ShoeApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
