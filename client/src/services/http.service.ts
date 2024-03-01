import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment.development';
import { AuthService } from './auth.service';
 
@Injectable({
  providedIn: 'root'
})
export class HttpService {
  public serverName=environment.apiUrl;  // To get server name
  private headers: HttpHeaders;
  constructor(private http: HttpClient, private authService:AuthService) {
    this.headers = this.createHeaders();
   }
   private createHeaders(): HttpHeaders {
    const authToken = this.authService.getToken();
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');
    if (authToken) {
      headers = headers.set('Authorization', `Bearer ${authToken}`);
    }
    return headers;
  }

  private getRequestOptions(): { headers: HttpHeaders } {
    return { headers: this.headers };
  }
 
  UpdateOrderStatus(newStatus:any,orderId:any):Observable<any> {
 
    // const authToken = this.authService.getToken();
    // let headers = new HttpHeaders();
    // headers = headers.set('Content-Type', 'application/json');
    // headers = headers.set('Authorization', `Bearer ${authToken}`);
    return this.http.put<any>(this.serverName+'/api/supplier/order/update/'+orderId+'?newStatus='+newStatus,{},this.getRequestOptions());
  }
 
  addEquipment(details:any,hospitalId: any): Observable<any> {
    // const authToken = this.authService.getToken();
    // let headers = new HttpHeaders();
    // headers = headers.set('Content-Type', 'application/json');
    // headers = headers.set('Authorization', `Bearer ${authToken}`);
    return this.http.post<any>(
      `${this.serverName}/api/hospital/equipment?hospitalId=${hospitalId}`,
      details, // Body
       this.getRequestOptions()
    );
  }
 
 
  getorders():Observable<any> {
   
    // const authToken = this.authService.getToken();
    // let headers = new HttpHeaders();
    // headers = headers.set('Content-Type', 'application/json');
    // headers = headers.set('Authorization', `Bearer ${authToken}`)
    return this.http.get(this.serverName+`/api/supplier/orders`,this.getRequestOptions());
  }
  getMaintenance():Observable<any> {
   
    // const authToken = this.authService.getToken();
    // let headers = new HttpHeaders();
    // headers = headers.set('Content-Type', 'application/json');
    // headers = headers.set('Authorization', `Bearer ${authToken}`)
    return this.http.get(this.serverName+`/api/technician/maintenance`,this.getRequestOptions());
  }
  getHospital():Observable<any> {
   
    // const authToken = this.authService.getToken();
    // let headers = new HttpHeaders();
    // headers = headers.set('Content-Type', 'application/json');
    // headers = headers.set('Authorization', `Bearer ${authToken}`)
    return this.http.get(this.serverName+`/api/hospitals`,this.getRequestOptions());
  }
  getEquipmentById(id:any):Observable<any> {
   
    // const authToken = this.authService.getToken();
    // let headers = new HttpHeaders();
    // headers = headers.set('Content-Type', 'application/json');
    // headers = headers.set('Authorization', `Bearer ${authToken}`)
    return this.http.get(this.serverName+`/api/hospital/equipment/`+id,this.getRequestOptions());
  }
 
  updateMaintenance(details:any,maintenanceId:any):Observable<any> {
 
    // const authToken = this.authService.getToken();
    // let headers = new HttpHeaders();
    // headers = headers.set('Content-Type', 'application/json');
    // headers = headers.set('Authorization', `Bearer ${authToken}`);
    return this.http.put(this.serverName+'/api/technician/maintenance/update/'+maintenanceId,details,this.getRequestOptions());
  }
  orderEquipment(details:any,equipmentId:any):Observable<any> {
 
    // const authToken = this.authService.getToken();
    // let headers = new HttpHeaders();
    // headers = headers.set('Content-Type', 'application/json');
    // headers = headers.set('Authorization', `Bearer ${authToken}`);
    return this.http.post(this.serverName+'/api/hospital/order?equipmentId='+equipmentId,details,this.getRequestOptions());
  }
  scheduleMaintenance(details:any,equipmentId:any):Observable<any> {
 
    // const authToken = this.authService.getToken();
    // let headers = new HttpHeaders();
    // headers = headers.set('Content-Type', 'application/json');
    // headers = headers.set('Authorization', `Bearer ${authToken}`);
    return this.http.post(this.serverName+'/api/hospital/maintenance/schedule?equipmentId='+equipmentId,details,this.getRequestOptions());
  }
  createHospital(details:any):Observable<any> {
 
    // const authToken = this.authService.getToken();
    // let headers = new HttpHeaders();
    // headers = headers.set('Content-Type', 'application/json');
    // headers = headers.set('Authorization', `Bearer ${authToken}`);
    return this.http.post(this.serverName+'/api/hospital/create',details,this.getRequestOptions());
  }
  Login(details:any):Observable<any> {
   
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');
    return this.http.post(this.serverName+'/api/user/login',details,this.getRequestOptions());
  }
  registerUser(details:any):Observable<any> {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');
    return this.http.post(this.serverName+'/api/user/register',details,this.getRequestOptions());
  }
 
 
 
}

