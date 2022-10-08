import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { SharedModule } from './shared/shared.module';

import { AppComponent } from './app.component';
import { TitleComponent } from './title/title.component';
import { TablesComponent } from './tables/tables.component';

import { HomeComponent } from './pages/home/home.component';
import { TransferenciasAgendadasComponent } from './pages/transferencias-agendadas/transferencias-agendadas.component';
import { ErrorComponent } from './pages/error/error.component';

@NgModule({
  declarations: [
    AppComponent,
    TitleComponent,
    TablesComponent,
    HomeComponent,
    TransferenciasAgendadasComponent,
    ErrorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    SharedModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
