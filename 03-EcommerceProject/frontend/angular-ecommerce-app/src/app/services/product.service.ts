import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { map } from "rxjs/operators";
import { Product } from "../common/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = "http://localhost:8080/api/products";

  constructor(private httpClient : HttpClient) { }

  getProductList(categoryId: number) : Observable<Product[]> {
    // @TODO: need to build URL based on category id
    const searchUrl =  `${this.baseUrl}/search/findByCategoryId?id=${categoryId}`;
    console.log(searchUrl);

    return this.httpClient.get<GetResponse>(searchUrl).pipe(
      map(response => {
        console.log(response._embedded.products);
        return response._embedded.products;
      })
    );
  }
}

interface GetResponse {
  _embedded: {
    products: Product[];
  }
}
