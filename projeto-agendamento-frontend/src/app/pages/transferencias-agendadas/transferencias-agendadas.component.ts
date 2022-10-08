import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-transferencias-agendadas',
  template:`
  <app-transferencias></app-transferencias>
  `,
  styleUrls: ['./transferencias-agendadas.component.css']
})
export class TransferenciasAgendadasComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
