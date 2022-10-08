import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransferenciasAgendadasComponent } from './transferencias-agendadas.component';

describe('TransferenciasAgendadasComponent', () => {
  let component: TransferenciasAgendadasComponent;
  let fixture: ComponentFixture<TransferenciasAgendadasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransferenciasAgendadasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransferenciasAgendadasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
