import { Injectable } from '@angular/core';
import { Order } from '../model/Order.model';
import { CaddyService } from './caddy.service';
import { HttpClient } from '@angular/common/http';
import { Client } from '../model/client.model';
import { CatalogueService } from './catalogue.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  public order: Order = new Order();

  constructor(private caddyService: CaddyService,
              private httpClient: HttpClient,
              private catService: CatalogueService) {}

  public setClient(client: Client) {
    this.order.client = client;
  }
  public loadProductsFromCaddy() {
    this.order.products = [];
    // tslint:disable-next-line:forin
    for (const key in this.caddyService.getCaddy().items) {
     this.order.products.push(this.caddyService.getCaddy().items[key]);
   }
  }
  public getTotal(): number {
    let total = 0;
    this.order.products.forEach(p => {
      total += p.price * p.quantity;
    });
    return total;
  }

  submitOrder() {
    return this.httpClient.post(this.catService.host + '/orders', this.order);
  }

  public getOrder(id: number): Observable<Order> {
    return this.httpClient.get<Order>(this.catService.host + '/orders/' + id);
  }
}
