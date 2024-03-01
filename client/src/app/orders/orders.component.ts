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

    formModel:any={status:null}
   showError:boolean=false;
   errorMessage:any;

   showMessage: any=false;
   responseMessage: any;
   orderList: any=[];

   statusModel:any={newStatus:null}
   constructor(public router:Router, public httpService:HttpService, private formBuilder: FormBuilder, private authService:AuthService) 
  {
    //remove the formbuilder and authservice
  }  
 ngOnInit(): void {
   this.getOrders();
   }  
 
   getOrders() {
     this.orderList=[];
     this.httpService.getorders().subscribe((data: any) => {
       this.orderList=data;
      console.log(data)
     }, error => {
       // Handle error
       this.showError = true;
       this.errorMessage = "An error occurred while logging in. Please try again later.";
       console.error('Login error:', error);
     });;
   }
   
   edit(value:any)
   {
    this.statusModel.cargoId=value.id
    this.showMessage=false;
   }
  //  disable(){
  //   if(this.statusModel.newStatus==="Delivered"){
  //     const bt = document.getElementById('btn') as HTMLButtonElement | null;
  //     bt?.setAttribute('disabled', '');
  //   }
  //  }
   update()
   { 
   
    if(this.statusModel.newStatus!=null)
    {   
      this.httpService.UpdateOrderStatus(this.statusModel.newStatus,this.statusModel.cargoId).subscribe((data: any) => {
        this.showMessage = true;
        this.responseMessage=`Status updated`;
        this.getOrders();
        
      }, error => {
        // Handle error
        this.showError = true;
        this.errorMessage = "An error occurred while logging in. Please try again later.";
        console.error('Login error:', error);
      });
      
    }
   }
   
 }
 
 