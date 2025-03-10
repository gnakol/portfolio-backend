import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NetworkSimulationComponent } from './network-simulation.component';

describe('NetworkSimulationComponent', () => {
  let component: NetworkSimulationComponent;
  let fixture: ComponentFixture<NetworkSimulationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NetworkSimulationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NetworkSimulationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
