import { Component, OnInit } from '@angular/core';
import { Customer } from './customer-info.model';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-customer-info',
  templateUrl: './customer-info.component.html',
  styleUrls: ['./customer-info.component.css']
})
export class CustomerInfoComponent implements OnInit {
  url : string = "http://localhost:8080/api/customer/";
  isCreateNew : boolean = false;
  isModify : boolean = false;
  customers : Customer[];
  customer : Customer;
  constructor(private http: HttpClient) { 
  }

  ngOnInit() {
    this.getCustomerList();  
  }

  getCustomerList(){
    this.http.get("http://localhost:8080/api/customer/")
    .subscribe((response) =>  this.customers=response as Customer[]);
    this.isCreateNew = false;
    this.isModify = false;
    this.customer=null;
  }
  
  emptyCustomer(){
    this.customer = new Customer();
    this.customer["addresses"] = JSON.parse('[{"type":"Residence"},{"type":"Office"}]');
    this.isCreateNew=true;
    this.isModify=false;
  }
  custSelected(customer : Customer){
    this.customer=Object.assign({}, customer);
    this.isCreateNew=false;
    this.isModify = true;
  }

  createNewCustomer(){
    this.http.post("http://localhost:8080/api/customer/",JSON.stringify(this.customer) ,{headers: {'Content-Type':'application/json'}})
    .subscribe((response) => this.getCustomerList(),
                (error : any)=> alert(error.error.message));
    ;
  }

  modifyCustomer(){
    console.log(JSON.stringify(this.customer));
    this.http.put("http://localhost:8080/api/customer/"+this.customer['customer-number'],JSON.stringify(this.customer),{headers: {'Content-Type':'application/json'}})
    .subscribe((response) => this.getCustomerList(),
                (error : any)=> alert(error.error.message));
    ;
  }

  deleteCustomer(){
    this.http.delete("http://localhost:8080/api/customer/"+this.customer['customer-number'],{headers: {'Content-Type':'application/json'}})
    .subscribe((response) => this.getCustomerList(),
                (error : any)=> alert(error.error.message));

  }
}
