import { TestBed } from '@angular/core/testing';

import { ListaTransferenciasService } from './lista-transferencias.service';

describe('ListaTransferenciasService', () => {
  let service: ListaTransferenciasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListaTransferenciasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
