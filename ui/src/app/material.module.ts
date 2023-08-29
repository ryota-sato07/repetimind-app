import { NgModule } from '@angular/core';
// import { CommonModule } from '@angular/common';
import { MatInputModule  } from '@angular/material/input'
import { MatButtonModule } from '@angular/material/button'
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule } from '@angular/material/dialog';

const modules = [
  // CommonModule,
  MatButtonModule,
  MatInputModule,
  MatCardModule,
  MatDialogModule
];

@NgModule({
  imports: modules,
  exports: modules
})
export class MaterialModule { }
