import { Routes } from '@angular/router';
import { OutputComponent } from './pages/output/output.component';
import { OutputAddComponent } from './pages/output-add/output-add.component';

/**
 * Routes configuration
 */
export const routes: Routes = [
  { path: 'output',     component: OutputComponent },
  { path: 'output/add', component: OutputAddComponent },
  { path: '**', redirectTo: 'output', pathMatch: 'full' }
];


