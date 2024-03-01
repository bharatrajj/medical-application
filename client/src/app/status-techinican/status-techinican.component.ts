import { Component, OnInit } from '@angular/core';
import { HttpService } from '../../services/http.service';

@Component({
  selector: 'app-status-techinican',
  templateUrl: './status-techinican.component.html',
  styleUrls: ['./status-techinican.component.scss']
})
export class StatusTechinicanComponent implements OnInit {

  constructor(private httpService:HttpService) { }
  ShowError:any=false;
  maintenanceList: any=[];
  errorMessage:any;
  ngOnInit(): void {
    this.getMaintenance()
  }
   
  getMaintenance() {
    this.maintenanceList=[];
    this.httpService.getMaintenance().subscribe((data: any) => {
      this.maintenanceList=data;
     console.log(data)
    }, error => {
      // Handle error
      this.ShowError = true;
      this.errorMessage = "An error has Occured.Try again";
      console.error('Login error:', error);
    });;
  }
}
