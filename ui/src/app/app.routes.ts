import { Routes } from '@angular/router';
import { OutputComponent } from './pages/output/output.component';

/**
 * Routes configuration
 */
export const routes: Routes = [
  { path: 'output', component: OutputComponent    },
  { path: '**', redirectTo: 'output', pathMatch: 'full' }
];


