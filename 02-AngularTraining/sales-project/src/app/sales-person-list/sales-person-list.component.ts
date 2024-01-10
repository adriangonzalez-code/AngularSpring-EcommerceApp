import { Component } from '@angular/core';
import {SalesPerson} from "./sales-person";

@Component({
  selector: 'app-sales-person-list',
  templateUrl: './sales-person-list-bootstrap.component.html',
  styleUrls: ['./sales-person-list.component.css']
})
export class SalesPersonListComponent {

  // Create an array of objects
  salesPersonList: SalesPerson[] = [
    new SalesPerson("Anup", "Kumar", "anup@mail.com", 50000),
    new SalesPerson("John", "Doe", "john@mail.com", 40000),
    new SalesPerson("Claire", "Murphy", "claire@mail.com", 90000),
    new SalesPerson("Mai", "Truong", "mai@mail.com", 60000),
  ];


}
