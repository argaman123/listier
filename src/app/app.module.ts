import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {provideAnimationsAsync} from '@angular/platform-browser/animations/async';
import {providePrimeNG} from 'primeng/config';
import Aura from '@primeng/themes/aura';
import {ButtonModule} from 'primeng/button';
import {OrderList} from 'primeng/orderlist';
import {Tag} from 'primeng/tag';
import { DragDropModule } from 'primeng/dragdrop';
import {Listbox} from 'primeng/listbox';
import {TableModule} from 'primeng/table';
import {CdkDrag, CdkDragHandle, CdkDropList} from '@angular/cdk/drag-drop';
import {ProgressBar} from 'primeng/progressbar';
import {Slider} from 'primeng/slider';
import {DropdownModule} from 'primeng/dropdown';
import {MultiSelect} from 'primeng/multiselect';
import {InputText} from 'primeng/inputtext';
import {IconField} from 'primeng/iconfield';
import {Rating} from 'primeng/rating';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ButtonModule,
    BrowserAnimationsModule,
    OrderList,
    DragDropModule,
    Tag,
    Listbox,
    TableModule,
    CdkDropList,
    CdkDrag,
    CdkDragHandle,
    ProgressBar,
    Slider,
    DropdownModule,
    FormsModule,
    MultiSelect,
    InputText,
    IconField,
    Rating
  ],
  providers: [
    provideAnimationsAsync(),
    providePrimeNG({
      theme: {
        preset: Aura
      }
    })
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
