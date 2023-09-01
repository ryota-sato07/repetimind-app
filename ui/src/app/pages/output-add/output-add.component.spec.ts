import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OutputAddComponent } from './output-add.component';

describe('OutputAddComponent', () => {
  let component: OutputAddComponent;
  let fixture: ComponentFixture<OutputAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OutputAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OutputAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
