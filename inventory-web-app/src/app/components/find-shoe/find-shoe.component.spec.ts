import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindShoeComponent } from './find-shoe.component';

describe('FindShoeComponent', () => {
  let component: FindShoeComponent;
  let fixture: ComponentFixture<FindShoeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FindShoeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FindShoeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
