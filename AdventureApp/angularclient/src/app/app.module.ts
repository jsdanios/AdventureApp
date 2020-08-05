import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Injectable } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS, HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UserService } from './user.service';
import { MapComponent } from './map/map.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MapEditorComponent } from './map-editor/map-editor.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home'},
  { path: 'home', component: MapComponent},
  { path: 'login', component: LoginComponent}
]

@Injectable()
export class XhrInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const xhr = req.clone({
      headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
    });
    return next.handle(xhr);
  }
}

@NgModule({
  declarations: [AppComponent, MapComponent, MapEditorComponent, LoginComponent, UserComponent],
  imports: [BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule],
  providers: [UserService, { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true}],
  bootstrap: [AppComponent],
})
export class AppModule {}

