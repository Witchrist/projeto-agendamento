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
    contaOrigem: ['', [Validators.required, Validators.minLength(6), Validators.pattern('^[0-9]{6}$')]],
    contaDestino: ['', [Validators.required, Validators.minLength(6), Validators.pattern('^[0-9]{6}$')]],
    vlrTransferencia: ['', [Validators.required, Validators.pattern('^[0-9]*\,[0-9]{2}$')]],
    dtTransferencia: ['', Validators.required]
  })

  constructor(private formBuilder: FormBuilder, private transferenciasService: TransferenciasService) { }

  ngOnInit(): void {
  }

  public addTransferencia(transferencia: Transferencias){
    var datePipe = new DatePipe("en-US");
    transferencia.dtTransferencia = datePipe.transform(transferencia.dtTransferencia, 'dd/MM/yyyy');
    var vlrFormat = transferencia.vlrTransferencia.toString().replace(',', '.');
    transferencia.vlrTransferencia = parseFloat(vlrFormat);

    if(this.agendamentoForm.valid){
      this.transferenciasService.addTransferencia(transferencia).subscribe({
        next: (response) => {
          console.log(response);
        },
        error: (error) =>{
          alert(error.error);
        },
    });
    } else {
      alert("Por favor preencha corretamente todos os campos do formulário");
    }
    
  }
}
