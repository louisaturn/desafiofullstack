import { Component, OnInit, Input } from '@angular/core';
import { Empresa } from './models/empresas';
import { EmpresasService, Entidade } from 'src/app/services/empresas.ts.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-read-all',
  templateUrl: './read-all.component.html',
  styleUrls: ['./read-all.component.css']
})
export class ReadAllComponent implements OnInit{
  list: Entidade[] = [];
  @Input() entidade: string = "";

  constructor(private service: EmpresasService, private router: ActivatedRoute){}
    ngOnInit(): void {
    // this.router.params.subscribe( params => this.entidade = !params["entidade"]? "empresas":params["entidade"]);
    this.findAll();
      
    }

    findAll(): void {
      this.service.findAll(this.entidade).subscribe((resposta) => {
        this.list = resposta;
      });
      
    }

    delete(identificador: any):void{
      this.service.delete(this.entidade, identificador).subscribe((resposta) => {
      if(resposta === null) {
        this.service.message("Empresa deletada com sucesso!")
        this.list = this.list.filter(entidade => entidade.identificador !== identificador)
      }
    })
    }
  }
