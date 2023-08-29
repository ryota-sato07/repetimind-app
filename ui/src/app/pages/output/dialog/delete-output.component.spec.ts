import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteOutputComponent } from './delete-output.component';

describe('DeleteOutputComponent', () => {
  let component: DeleteOutputComponent;
  let fixture: ComponentFixture<DeleteOutputComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteOutputComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteOutputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
