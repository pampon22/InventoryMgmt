import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddShoeComponent } from './add-shoe.component';

describe('AddShoeComponent', () => {
  let component: AddShoeComponent;
  let fixture: ComponentFixture<AddShoeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddShoeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddShoeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
