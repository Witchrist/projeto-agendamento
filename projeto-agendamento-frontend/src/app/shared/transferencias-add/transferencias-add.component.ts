import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Transferencias } from 'src/app/module/transferencias';
import { TransferenciasService } from 'src/app/services/transferencias.service';

@Component({
  selector: 'app-transferencias-add',
  templateUrl: './transferencias-add.component.html',
  styleUrls: ['./transferencias-add.component.css']
})
export class TransferenciasAddComponent implements OnInit {

  public agendamentoForm: FormGroup = this.formBuilder.group({
    contaOrigem: ['', Validators.required],
    contaDestino: ['', Validators.required],
    vlrTransferencia: ['', Validators.required],
    dtTransferencia: ['', Validators.required]
  })

  constructor(private formBuilder: FormBuilder, private transferenciasService: TransferenciasService) { }

  ngOnInit(): void {
  }

  public addTransferencia(transferencia: Transferencias){
    var datePipe = new DatePipe("en-US");
    transferencia.dtTransferencia = datePipe.transform(transferencia.dtTransferencia, 'dd/MM/yyyy');

    console.log(transferencia);
    this.transferenciasService.addTransferencia(transferencia).subscribe({
      next: (response) => console.log(response),
      error: (error) => console.log(error),
  });
  }
}
