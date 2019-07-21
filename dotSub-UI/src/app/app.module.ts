import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ButtonModule } from 'primeng/button';
import { FileuploadComponent } from './fileupload/fileupload.component';
import { FileUploadModule } from 'primeng/fileupload';
import { HttpClientModule } from '@angular/common/http';
import { ProgressSpinnerModule } from 'primeng/progressspinner';
import {BlockUIModule} from 'primeng/blockui';
import {DialogModule} from 'primeng/dialog';
@NgModule({
  declarations: [
    AppComponent,
    FileuploadComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ButtonModule,
    FileUploadModule,
    HttpClientModule,
    ProgressSpinnerModule,
    BlockUIModule,
    DialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
