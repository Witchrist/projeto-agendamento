import { Component, OnInit } from '@angular/core';
import { Transferencias } from 'src/app/module/transferencias';
import { TransferenciasService } from 'src/app/services/transferencias.service';


@Component({
  selector: 'app-transferencias',
  templateUrl: './transferencias.component.html',
  styleUrls: ['./transferencias.component.css']
})
export class TransferenciasComponent implements OnInit {

  public listaTransferencias: Array<Transferencias> = [];

  constructor(private transferenciasService: TransferenciasService) { }

  ngOnInit(): void {
    this.transferenciasService.getListaTransferencias().subscribe({
      next: (response) => this.listaTransferencias = response,
      error: (error) => console.log(error),
  });

  }

}
