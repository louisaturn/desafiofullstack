import { Component, OnInit } from '@angular/core';
import { Empresa } from './models/empresas';
import { EmpresasService } from 'src/app/services/empresas.ts.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-read-all',
  templateUrl: './read-all.component.html',
  styleUrls: ['./read-all.component.css']
})
export class ReadAllComponent implements OnInit{
  list: Empresa[] = [];

  constructor(private service: EmpresasService, private router: Router){}
    ngOnInit(): void {
      this.findAll();
      
    }

    findAll(): void {
      this.service.findAll().subscribe((resposta) => {
        this.list = resposta;
      })
    }

    delete(cnpj: any):void{
      this.service.delete(cnpj).subscribe((resposta) => {
      if(resposta === null) {
        this.service.message("Empresa deletada com sucesso!")
        this.list = this.list.filter(empresa => empresa.cnpj !== cnpj)
      }
    })
    }
  }
