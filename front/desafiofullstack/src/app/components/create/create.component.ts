import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Empresa } from '../read-all/models/empresas';
import { EmpresasService } from 'src/app/services/empresas.ts.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  entidade: String = "";

  empresa: Empresa = {
    nomeFantasia: '',
    cnpj: '',
    cep: '',
    fornecedores: []
  }

  constructor(private route: ActivatedRoute,private router:Router, private service: EmpresasService) {

  }
  ngOnInit(): void {

  }

  create(): void {
    this.service.create("empresas", this.empresa).subscribe((resposta) => {
      this.service.message('Empresa criada com sucesso');
      this.router.navigate(['']);
    }, err => {
      this.service.message('Falha ao criar a Empresa');
      this.router.navigate(['']);
    })
  }

  cancel(): void {
    this.router.navigate(['']);
  }
}
