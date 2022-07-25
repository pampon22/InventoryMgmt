import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShoeFormComponent } from './shoe-form.component';

describe('ShoeFormComponent', () => {
  let component: ShoeFormComponent;
  let fixture: ComponentFixture<ShoeFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShoeFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShoeFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
