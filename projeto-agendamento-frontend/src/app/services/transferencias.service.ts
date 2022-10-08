import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Transferencias } from '../module/transferencias';

@Injectable({
  providedIn: 'root'
})
export class TransferenciasService {

  private transferencia = {
    contaOrigem: [''],
    contaDestino: [''],
    vlrTransferencia: [''],
    dtTransferencia: ['']
  }

  private url: string = "http://localhost:8080/";

  constructor(private http: HttpClient) { }

  public setTransferencia(contaOrigem: string[], contaDestino: string[], vlrTransferencia: string[], dtTransferencia: string[]  ){
    this.transferencia.contaOrigem=contaOrigem;
    this.transferencia.contaDestino=contaDestino;
    this.transferencia.vlrTransferencia=vlrTransferencia;
    this.transferencia.dtTransferencia=dtTransferencia;
  }

  public getListaTransferencias() : Observable<Array<Transferencias>>{
    return this.http.get<Array<Transferencias>>(`${this.url}transferencia`)
    .pipe(
      response => response,
      error => error
    );
  }

  public addTransferencia(transferencia: Transferencias) : Observable<Transferencias>{
    return this.http.post<Transferencias>(`${this.url}transferencia`, transferencia)
    .pipe(
      response => response,
      error => error
    );
  }
}
