import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransferenciasAddComponent } from './transferencias-add.component';

describe('TransferenciasAddComponent', () => {
  let component: TransferenciasAddComponent;
  let fixture: ComponentFixture<TransferenciasAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransferenciasAddComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransferenciasAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
