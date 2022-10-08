import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  template:`
  <app-transferencias-add></app-transferencias-add>
  `,
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
