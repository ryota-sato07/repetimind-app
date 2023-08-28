import { NgModule } from '@angular/core';
// import { CommonModule } from '@angular/common';
import {
  MatButtonModule,
  MatInputModule,
  MatCardModule
} from '@angular/material';

const modules = [
  // CommonModule,
  MatButtonModule,
  MatInputModule,
  MatCardModule
];

@NgModule({
  imports: modules,
  exports: modules
})
export class MaterialModule { }
