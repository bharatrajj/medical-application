import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidationErrors, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';
 
 
@Component({
  selector: 'app-maintenance',
  templateUrl: './maintenance.component.html',
  styleUrls: ['./maintenance.component.scss']
})
export class MaintenanceComponent implements OnInit {
  // itemForm: FormGroup;
  formModel:any={status:null};
  showError:boolean=false;
  errorMessage:any;
  hospitalList:any=[];
  assignModel: any={};
  itemForm: FormGroup;
  showMessage: any;
  responseMessage: any;
  maintenanceList: any=[];
  maintenanceObj: any={};
  constructor(public router:Router, public httpService:HttpService, private formBuilder: FormBuilder, private authService:AuthService)
    {
      // this.itemForm = //complete this function
      this.itemForm=this.formBuilder.group({
        maintenanceId:['',[Validators.required]],
        scheduledDate:['',[Validators.required]],
        completedDate:['',[Validators.required]],
        description:['',[Validators.required]],
        status:['',[Validators.required]]
      })
     
 
 
 
}  
ngOnInit(): void {
  this.getMaintenance();
  }  
  dateValidator(control: AbstractControl): ValidationErrors | null {
    //complete this function
    const pattern=/^\d{4}-\d{2}-\d{2}%/;         // for Date Validation regix
    if(pattern.test(control.value)){
      return {invalidDate:true}
    }
    return null;
  }
  getMaintenance() {
  //complete this function
  this.httpService.getMaintenance().subscribe(data=>{
    this.maintenanceList=data;
  })
  }
  viewDetails(details:any)
  {
    //complete this function
   
  }
  edit(val:any)
  {
   //complete this function
   this.itemForm.patchValue({
    maintenanceId:val.id,
    scheduledDate:val.scheduledDate,
    completedDate:val.completedDate,
    description:val.description,
    status:val.status
   });
 
}
update()
{
    this.httpService.updateMaintenance(this.itemForm.value,this.itemForm.value.id).subscribe((response)=>{
             this.responseMessage=response;
    })
}
}