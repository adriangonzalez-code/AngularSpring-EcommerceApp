import { Injectable } from '@angular/core';
import { Observable, of } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { Country } from "../common/country";
import { map } from "rxjs/operators";
import {State} from "../common/state";

@Injectable({
  providedIn: 'root'
})
export class ShopFormServiceService {

  private countriesUrl: string = 'http://localhost:8080/api/countries';
  private statesUrl: string = 'http://localhost:8080/api/states';

  constructor(private httpClient: HttpClient) { }

  getCreditCardMonths(startMont: number): Observable<number[]> {
    let data: number[] = [];

    // Build an array for "Month" dropdown list
    // Start at current month and loop until
    for (let theMonth = startMont; theMonth <= 12; theMonth++) {
      data.push(theMonth);
    }

    return of(data);
  }

  getCreditCardYears() : Observable<number[]> {
    let data: number[] = [];

    // Build an array for "Year" dropdown list
    // Start at current year and loop for the next 10 years
    const startYear: number = new Date().getFullYear();
    const endYear: number = startYear + 10;

    for (let theYear= startYear; theYear <= endYear; theYear++) {
      data.push(theYear);
    }

    return of(data);
  }

  getCountries() : Observable<Country[]> {
    return this.httpClient.get<GetResponseCountries>(this.countriesUrl).pipe(
      map(response => response._embedded.countries)
    );
  }

  getStates(theCountryCode: string) : Observable<State[]> {
    // Search URL
    const searchStatesUrl = `${this.statesUrl}/search/findByCountryCode?code=${theCountryCode}`;

    return this.httpClient.get<GetResponseStates>(searchStatesUrl).pipe(
      map(response => response._embedded.states)
    );
  }
}

interface GetResponseCountries {
  _embedded: {
    countries: Country[];
  }
}

interface GetResponseStates {
  _embedded: {
    states: State[];
  }
}
