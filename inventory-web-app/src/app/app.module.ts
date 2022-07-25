import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {TableModule} from 'primeng/table';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ShoeDetailsComponent } from './components/shoe-details/shoe-details.component';
import { ShoeListComponent } from './components/shoe-list/shoe-list.component';
import { ShoeFormComponent } from './components/shoe-form/shoe-form.component';
import { FindShoeComponent } from './components/find-shoe/find-shoe.component';
import { WarehouseListComponent } from './components/warehouse-list/warehouse-list.component';

@NgModule({
  declarations: [
    AppComponent,
    ShoeDetailsComponent,
    ShoeListComponent,
    ShoeFormComponent,
    FindShoeComponent,
    WarehouseListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    TableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
