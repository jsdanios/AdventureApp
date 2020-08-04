//default map center
let mapLocation = new MapLocation("55.5815245", "36.8251383");

import {
  Component,
  ViewChild,
  ElementRef,
  OnInit,
} from '@angular/core';
import { MapLocation } from '../map-location';
import { MapService } from '../map-service.service';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css'],
})

export class MapComponent implements OnInit{

  constructor(private mapService: MapService) {}

  @ViewChild('mapContainer', { static: true }) gmap: ElementRef;
  map: google.maps.Map;
  lat = Number(mapLocation.lat);
  lng = Number(mapLocation.lng);

  coordinates = new google.maps.LatLng(this.lat, this.lng);

  mapOptions: google.maps.MapOptions = {
    center: this.coordinates,
    zoom: 8,
  };

  marker = new google.maps.Marker({
    position: this.coordinates,
    map: this.map,
  });


  ngOnInit() {
    this.mapService.getLocationForMap(mapLocation).subscribe(data => {
      mapLocation = data;
    })
    this.mapInitializer();
  }

  mapInitializer() {
    this.map = new google.maps.Map(this.gmap.nativeElement, this.mapOptions);
    this.marker.setMap(this.map);
  }

}
