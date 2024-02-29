import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatusTechinicanComponent } from './status-techinican.component';

describe('StatusTechinicanComponent', () => {
  let component: StatusTechinicanComponent;
  let fixture: ComponentFixture<StatusTechinicanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StatusTechinicanComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StatusTechinicanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
