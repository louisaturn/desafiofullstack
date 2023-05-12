import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmpresasService } from 'src/app/services/empresas.ts.service';
import { Empresa } from '../read-all/models/empresas';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent {
  empresa: Empresa = {
    nomeFantasia: '',
    cnpj: '',
    cep: ''
  }

  constructor(private router: Router, private service: EmpresasService, private route: ActivatedRoute) {

  }
  ngOnInit(): void {
    this.empresa.cnpj = this.route.snapshot.paramMap.get("cnpj")!;
    this.findById();
  }

  findById(): void {
    this.service.findById(this.empresa).subscribe((resposta) =>{
      this.empresa = resposta;
    })
  }

  update(): void {
    this.service.update(this.empresa).subscribe((resposta) => {
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
}
