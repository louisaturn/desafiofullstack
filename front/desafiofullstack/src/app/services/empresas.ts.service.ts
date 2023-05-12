import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { enviroment } from 'src/enviroments/enviroments';
import { Empresa } from '../components/read-all/models/empresas';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class EmpresasService {

  baseUrl = enviroment.baseUrl;

  constructor(private http: HttpClient, private snack: MatSnackBar) {}

  findAll(): Observable<Empresa[]> {
    return this.http.get<Empresa[]>(this.baseUrl);
  }

  findById(cnpj: any): Observable<Empresa> {
    const url = `${this.baseUrl}/${cnpj}`
    return this.http.get<Empresa>(url);
  }

  delete(cnpj: any):Observable<void> {
    const url = `${this.baseUrl}/${cnpj}`
    return this.http.delete<void>(url);
  }

  create(empresa: Empresa):Observable<Empresa> {
    return this.http.post<Empresa>(this.baseUrl, empresa);
  }

  update(empresa: Empresa):Observable<Empresa> {
    const url = `${this.baseUrl}/${empresa.cnpj}`
    return this.http.put<Empresa>(url, empresa);
  }

  message(msg: String): void{
    this.snack.open(`${msg}`, 'OK', {
      horizontalPosition: 'center',
      verticalPosition: 'top',
      duration: 5000
    })
  }
}
