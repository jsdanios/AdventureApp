import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MapLocation } from '../app/map-location';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

//communicates with backend - AdventureLocationController
export class MapService {
  private mapUrl: string;

  constructor(private http: HttpClient) {
    this.mapUrl = 'http://localhost:8080/map';
  }

  public getLocationForMap(mapLocation: MapLocation): Observable<MapLocation> {
    return this.http.post<MapLocation>(this.mapUrl, location);
  }
}
