import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidationErrors, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss']
})
export class OrdersComponent implements OnInit {

 
   showError:boolean=false;
   errorMessage:any;

   showMessage: any;
   responseMessage: any;
   orderList: any=[]

   statusModel:any={newStatus:null}
   constructor(public router:Router, public httpService:HttpService, private formBuilder: FormBuilder, private authService:AuthService) 
  {
  }  
 ngOnInit(): void {
    this.getOrders();
   }  
 
   getOrders() {
     //complete this function
     this.httpService.getorders().subscribe((res:any)=>{
      this.orderList=res;
     },error=>{
      this.showError=true;
      this.errorMessage="Error in updating status"
     })

   }
   viewDetails(details:any)
   {
    
   }
   edit(value:any)
   {
     //complete this function
     this.statusModel.orderId=value.id;

   }
   update()
   {
    //complete this function
    if(this.statusModel.newStatus!=null){
      this.showMessage=false;
      this.httpService.UpdateOrderStatus(this.statusModel.newStatus,this.statusModel.orderId).subscribe((res:any)=>{
        this.showMessage=true;
        this.responseMessage="Status Updated Successfully!"
        this.getOrders();
      },error=>{
        this.showError=true;
        this.errorMessage="Error in updating status";
      });
    }

   }
 }
 
 