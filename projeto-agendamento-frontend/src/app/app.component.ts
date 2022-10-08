import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <router-outlet></router-outlet>
    <app-transferencias-add></app-transferencias-add>
    <app-transferencias></app-transferencias>
  `
})
export class AppComponent {
}
