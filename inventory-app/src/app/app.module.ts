import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WarehouseListComponent } from './warehouse-list/warehouse-list.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FindWarehouseComponent } from './find-warehouse/find-warehouse.component';
import { AddWarehouseComponent } from './add-warehouse/add-warehouse.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ShoeListComponent } from './shoe-list/shoe-list.component';
import { ShoeApiService } from './services/shoe-api.service';
// import { DataTableModule } from 'angular-datatables';


@NgModule({
  declarations: [
    AppComponent,
    WarehouseListComponent,
    ShoeListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
  ],
  providers: [ShoeApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
