import { Component } from '@angular/core';
import { Fornecedor } from '../read-all/models/fornecedores';
import { ActivatedRoute, Router } from '@angular/router';
import { EmpresasService } from 'src/app/services/empresas.ts.service';

@Component({
  selector: 'app-createfornecedores',
  templateUrl: './createfornecedores.component.html',
  styleUrls: ['./createfornecedores.component.css']
})
export class CreatefornecedoresComponent {
  entidade: String = "";

  fornecedor: Fornecedor = {
    cep: "",
    cnpjOuCpf: "",
    email: "",
    nome: "",
    dataNascimento: "",
    rg: ""
  }

  constructor(private route: ActivatedRoute,private router:Router, private service: EmpresasService) {

  }
  ngOnInit(): void {

  }

  create(): void {
    this.service.create("fornecedores", this.fornecedor).subscribe((resposta) => {
      this.service.message('Fornecedor criado com sucesso');
      this.router.navigate(['']);
    }, err => {
      this.service.message('Falha ao criar o Fornecedor');
      this.router.navigate(['']);
    })
  }

  cancel(): void {
    this.router.navigate(['']);
  }
}
