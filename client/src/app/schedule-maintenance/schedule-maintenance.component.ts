import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidationErrors, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';


@Component({
  selector: 'app-schedule-maintenance',
  templateUrl: './schedule-maintenance.component.html',
  styleUrls: ['./schedule-maintenance.component.scss']
})
export class ScheduleMaintenanceComponent implements OnInit {
  itemForm: FormGroup;

  formModel:any={status:null};
  showError:boolean=false;
  errorMessage:any;
  hospitalList:any=[];
  assignModel: any={};

  showMessage: any;
  responseMessage: any;
  equipmentList: any=[];
  constructor(public router:Router, public httpService:HttpService, private formBuilder: FormBuilder, private authService:AuthService) 
    {
      // this.itemForm =init form here
      this.itemForm=this.formBuilder.group({
        hospitalId:['',[Validators.required]],
        equipmentId:['',[Validators.required]],
        scheduledDate:['',[Validators.required,this.dateValidator]],
        completedDate:['',[Validators.required,this.dateValidator]],
        description:['',[Validators.required]],
        status:['',[Validators.required]]
      })


}  ngOnInit(): void {
    this.getHospital()

  }
  dateValidator(control: AbstractControl): ValidationErrors | null {
  //  complete this function
  const df=/^\d{4}-\d{2}-d{2}$/
      if(!df.test(control.value)){
        return{invalidDate:true}
    }
    return null;
  }
  getHospital() {
    //  complete this function
     //add all hospitals in hospital List
     this.httpService.getHospital().subscribe(
      (response: any) => {
        this.hospitalList = response;
      },
      (error: any) => {
        this.showError = true;
        this.errorMessage = error.message || 'An error occurred while fetching hospitals.';
      }
    );
  }


  onSubmit()
  {
    //complete this function
    if(this.itemForm.valid){
      this.httpService.scheduleMaintenance(this.itemForm.value, this.itemForm.value.equipmentId).subscribe(
        (response: any) => {
          this.showMessage = true;
          this.responseMessage = 'Scheduled Maintenance Successfully!';
          this.itemForm.reset(); //reset form after successful submission
        },
        (error: any) => {
          this.showError = true;
          this.responseMessage = error.message || 'Error in Scheduling Maintenance :(';
        }
      );
    }else{
      this.showError = true;
      this.responseMessage = 'Please fill all the required fields correctly.';
      return;
    }
    }
    
  onHospitalSelect($event: any) {
    //complete this function
   let id= $event.target.value
   this.httpService.getEquipmentById(id).subscribe((res:any)=>{
    this.equipmentList=res; //stores equipments of a particular hospital in it
   })

   
     

}

}