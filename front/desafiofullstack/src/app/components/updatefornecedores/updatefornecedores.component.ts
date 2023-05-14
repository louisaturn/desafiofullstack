import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmpresasService } from 'src/app/services/empresas.ts.service';
import { Fornecedor } from '../read-all/models/fornecedores';

@Component({
  selector: 'app-updatefornecedores',
  templateUrl: './updatefornecedores.component.html',
  styleUrls: ['./updatefornecedores.component.css']
})
export class UpdatefornecedoresComponent {
  identificador: String = "";

  fornecedor: Fornecedor = {
    nome: '',
    cnpjOuCpf: '',
    cep: '',
    email: ''
  }

  constructor(private router: Router, private service: EmpresasService, private route: ActivatedRoute) {

  }
  ngOnInit(): void {
    this.identificador = this.route.snapshot.paramMap.get("identificador")!;

    this.findById();
  }

  findById(): void {
    this.service.findById<any>("fornecedores", this.identificador).subscribe((resposta) =>{
      this.fornecedor = resposta;
    })
  }

  update(): void {
    this.service.update("fornecedores", this.fornecedor, this.identificador).subscribe((resposta) => {
    this.service.message('Fornecedor atualizado com sucesso');
    this.router.navigate(['']);
  }, err =>
  {
    this.service.message('Falha ao atualizar o fornecedor');
    this.router.navigate(['']);
  })
}

  cancel(): void {
    this.router.navigate(['']);
  }
}
