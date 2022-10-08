import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

//Components
import { TransferenciasComponent } from './transferencias/transferencias.component';
import { TransferenciasAddComponent } from './transferencias-add/transferencias-add.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from '../app-routing.module';



@NgModule({
  declarations: [
    TransferenciasComponent,
    TransferenciasAddComponent
  ],
  exports: [
    TransferenciasComponent,
    TransferenciasAddComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule
  ]
})
export class SharedModule { }
