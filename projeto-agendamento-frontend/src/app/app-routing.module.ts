import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ErrorComponent } from './pages/error/error.component';
import { HomeComponent } from './pages/home/home.component';
import { TransferenciasAgendadasComponent } from './pages/transferencias-agendadas/transferencias-agendadas.component';

const routes: Routes = [
  {path : "", component: HomeComponent, pathMatch: 'full'},
  {path : "transferencias-agendadas", component: TransferenciasAgendadasComponent},
  {path : "**", component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
