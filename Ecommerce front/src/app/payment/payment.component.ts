import { Component, OnInit } from '@angular/core';
import { Order } from '../model/Order.model';
import { Router, ActivatedRoute } from '@angular/router';
import { OrderService } from '../services/order.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  angFormP: FormGroup;
  paymentAmount: number;
  currentOrder: Order;
  panelStyle: any;
  mode: number;
  private data: string;
  constructor(private fb: FormBuilder,
    private router: Router, private route: ActivatedRoute,
              private orderService: OrderService) {this.createForm(); }

  createForm() {
    this.angFormP = this.fb.group({
      cardNumber: ['', Validators.required ],
      codeVerif: ['', Validators.required ],
      amount: ['', Validators.required ]
    });
  }
  ngOnInit() {
    const id = this.route.snapshot.params.orderID;
    this.orderService.getOrder(id).subscribe(data => {
      this.currentOrder = data;
    }, err => {
      console.log(err);
    });
  }

  onParOrder(data) {
    console.log(data);
  }

  onOrder() {
    console.log(this.data);
  }

  onPayOrder() {
    console.log(this.data);
  }
}

