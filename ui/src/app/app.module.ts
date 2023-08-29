import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HTTP_INTERCEPTORS, HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';

import { routes } from './app.routes';
import { AppComponent } from './app.component';
import { MaterialModule } from './material.module';

import { AppHttpInterceptorService } from './http-interceptor.service';
import { OutputComponent } from './pages/output/output.component';
import { SectionHeaderComponent } from './shared/section-header/section-header.component';
import { SectionSidebarComponent } from './shared/section-sidebar/section-sidebar.component';

import * as deleteDialog from './pages/output/dialog';


/**
 *  Module Definition
 */
@NgModule({
  declarations: [
    // 共通レイアウト
    AppComponent,
    SectionHeaderComponent,
    SectionSidebarComponent,
    // ページレイアウト
    OutputComponent,
    // ダイアログ
    deleteDialog.DeleteOutputComponent,
  ],
  imports: [
    BrowserModule,
    MaterialModule,
    HttpClientModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'Csrf-Token',
      headerName: 'Csrf-Token',
    }),
    RouterModule.forRoot(routes),
    BrowserAnimationsModule
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
