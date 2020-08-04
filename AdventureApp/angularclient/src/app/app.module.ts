import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UserServiceService } from './user-service.service';
import { MapComponent } from './map/map.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MapEditorComponent } from './map-editor/map-editor.component';2

@NgModule({
  declarations: [AppComponent, MapComponent, MapEditorComponent],
  imports: [BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule],
  providers: [UserServiceService],
  bootstrap: [AppComponent],
})
export class AppModule {}
