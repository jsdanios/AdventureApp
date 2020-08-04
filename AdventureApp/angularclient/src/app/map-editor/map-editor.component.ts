import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MapLocation } from '../map-location';
import { ActivatedRoute, Router } from '@angular/router';
import { MapService } from '../map-service.service';

@Component({
  selector: 'app-map-editor',
  templateUrl: './map-editor.component.html',
  styleUrls: ['./map-editor.component.css']
})
export class MapEditorComponent {

  mapLocation: MapLocation;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private mapService: MapService) {
      this.mapLocation = new MapLocation( "55.5815245", "36.8251383");
    }

  mapForm = new FormGroup({
    address: new FormControl(''),
    cityz: new FormControl(''),
    state: new FormControl(''),
  });

  //communicates with map-service
  onSubmit() {
    this.mapService.getLocationForMap(this.mapLocation).subscribe(result => this.goToMap());
  }

  goToMap() {
    this.router.navigate(['/map']);
  }

}
