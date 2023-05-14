import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators'
import { enviroment } from 'src/enviroments/enviroments';
import { Empresa } from '../components/read-all/models/empresas';
import { Fornecedor } from '../components/read-all/models/fornecedores';
import { MatSnackBar } from '@angular/material/snack-bar';

export type Entidade = {
  nome: String,
  identificador: String,
  cep: String
}

@Injectable({
  providedIn: 'root'
})
export class EmpresasService {

  baseUrl = enviroment.baseUrl;

  constructor(private http: HttpClient, private snack: MatSnackBar) {}

  findAll<T = any>(entidade: string): Observable<Entidade[]> {
    return this.http.get<T[]>(`${this.baseUrl}/${entidade}`).pipe(map(values => {
      if(entidade == "empresas") {
        return values.map(obj => {
          return {
            nome: (<Empresa>obj).nomeFantasia,
            identificador: (<Empresa>obj).cnpj,
            cep: (<Empresa>obj).cep
          }
        });
      } else if (entidade == "fornecedores") {
        return values.map(obj => {
          return {
            nome: (<Fornecedor>obj).nome,
            identificador: (<Fornecedor>obj).cnpjOuCpf,
            cep: (<Fornecedor>obj).cep
          }
        });
      }

      return <Entidade[]>values;
    }));
  }

  findById<T>(entidade: String ,identificador: any): Observable<T> {
    const url = `${this.baseUrl}/${entidade}/${identificador}`
    return this.http.get<T>(url);
  }

  delete(entidade: String, identificador: any):Observable<void> {
    const url = `${this.baseUrl}/${entidade}/${identificador}`
    return this.http.delete<void>(url);
  }

  create<T>(entidade: String, obj: T):Observable<T> {
    return this.http.post<T>(`${this.baseUrl}/${entidade}`, obj);
  }

  update<T>(entidade: String, obj: T, identificador: any):Observable<T> {
    return this.http.put<T>(`${this.baseUrl}/${entidade}/${identificador}`, obj);
  }

  message(msg: String): void{
    this.snack.open(`${msg}`, 'OK', {
      horizontalPosition: 'center',
      verticalPosition: 'top',
      duration: 5000
    })
  }
}
