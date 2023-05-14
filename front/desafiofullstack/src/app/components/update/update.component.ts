import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmpresasService, Entidade } from 'src/app/services/empresas.ts.service';
import { Empresa } from '../read-all/models/empresas';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent {
  identificador: String = "";

  empresa: Empresa = {
    nomeFantasia: '',
    cnpj: '',
    cep: '',
    fornecedores: []
  }

  fornecedores: {
    entidade: Entidade,
    fornece: Boolean
  }[] = []

  selectedFornecedor? : Entidade;

  constructor(private router: Router, private service: EmpresasService, private route: ActivatedRoute) {

  }
  ngOnInit(): void {
    this.identificador = this.route.snapshot.paramMap.get("identificador")!;

    this.findById();
    this.service.findAll("fornecedores").forEach(entidades=>{
      this.fornecedores = entidades.map(entidade => {
        return {entidade, fornece: !!this.empresa.fornecedores.find(fornecedor => fornecedor.cnpjOuCpf == entidade.identificador)};
      })
    });

    console.log(this.fornecedores)
  }

  findById(): void {
    this.service.findById<Empresa>("empresas", this.identificador).subscribe((resposta) =>{
      this.empresa = resposta;
    })
  }

  update(): void {
    this.service.update("empresas", this.empresa, this.identificador).subscribe((resposta) => {
    this.service.message('Empresa atualizada com sucesso');
    this.router.navigate(['']);
  }, err =>
  {
    this.service.message('Falha ao atualizar a empresa');
    this.router.navigate(['']);
  })
}

  cancel(): void {
    this.router.navigate(['']);
  }

  addFornecedor(): void {
    if(!this.selectedFornecedor) {
      return;
    }

    this.empresa.fornecedores.push({
      cnpjOuCpf: this.selectedFornecedor.identificador,
      cep:"",
      email:"",
      nome: this.selectedFornecedor.nome,
      dataNascimento:"",
      rg:""
    });
    let forn = this.fornecedores.find(fornecedor => fornecedor.entidade.identificador == this.selectedFornecedor?.identificador)
    forn!.fornece = true;
  }
}

