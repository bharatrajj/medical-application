import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-dashbaord',
  templateUrl: './dashbaord.component.html',
  styleUrls: ['./dashbaord.component.scss']
})
export class DashbaordComponent implements OnInit{
  roleType:any;
   constructor(private authService:AuthService){

   }
  ngOnInit(): void {
       this.roleType=this.authService.getRole;
       
  }
}
