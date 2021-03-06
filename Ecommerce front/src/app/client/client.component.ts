import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { CaddyService } from '../services/caddy.service';
import { Router } from '@angular/router';
import { Client } from '../model/client.model';
import { OrderService } from '../services/order.service';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {


  angForm: FormGroup;
  public mode:number=0;
  panelStyle:string= "panel-default";
  name: any;




  constructor(private fb: FormBuilder,
              public orderService:OrderService,
              private authService:AuthenticationService,
              public caddyService:CaddyService,
              private router:Router) {this.createForm(); }

  createForm() {
    this.angForm = this.fb.group({
      name: ['', Validators.required ],
      address: ['', Validators.required ],
      number: ['', Validators.required ],
      email: ['', [Validators.required, Validators.email] ]
    });
  }

   ngOnInit()
  {

  }

  onSaveClient(client:Client) {
    client.username=this.authService.authenticatedUser.username;
    this.orderService.setClient(client);
    this.caddyService.setClient(client);
    this.orderService.loadProductsFromCaddy();
    this.mode=1;
  }

  onOrder() {
    this.orderService.submitOrder().subscribe(data=>{
      this.orderService.order.id=data['id'];
      this.orderService.order.date=data['date'];
      this.panelStyle="panel-success";
    },err=>{
      console.log(err);
    });
  }

  onPayOrder() {
    this.router.navigateByUrl("/payment/"+this.orderService.order.id);
  }
}
