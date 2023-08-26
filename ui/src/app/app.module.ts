import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HTTP_INTERCEPTORS, HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';

import { routes } from './app.routes';
import { AppComponent } from './app.component';

import { AppHttpInterceptorService } from './http-interceptor.service';
import { OutputComponent } from './pages/output/output.component';
import { SectionHeaderComponent } from './shared/section-header/section-header.component';
import { SectionSidebarComponent } from './shared/section-sidebar/section-sidebar.component';

/**
 *  Module Definition
 */
@NgModule({
  declarations: [
    AppComponent,
    OutputComponent,
    SectionHeaderComponent,
    SectionSidebarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'Csrf-Token',
      headerName: 'Csrf-Token',
    }),
    RouterModule.forRoot(routes)
  ],
  providers: [
    {
      multi: true,
      provide: HTTP_INTERCEPTORS,
      useClass: AppHttpInterceptorService
    }
  ],
  bootstrap: [AppComponent]
})

export class AppModule {}
