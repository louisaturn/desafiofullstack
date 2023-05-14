import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReadAllComponent } from './components/read-all/read-all.component';
import { CreateComponent } from './components/create/create.component';
import { UpdateComponent } from './components/update/update.component';
import { MainComponent } from './components/main/main.component';
import { UpdatefornecedoresComponent } from './components/updatefornecedores/updatefornecedores.component';
import { CreatefornecedoresComponent } from './components/createfornecedores/createfornecedores.component';

const routes: Routes = [
  {
    path: '',
    component: MainComponent
  },
  {
    path: 'empresas/create',
    component: CreateComponent
  },
  {
    path: 'fornecedores/create',
    component: CreatefornecedoresComponent
  },
  {
    path: 'empresas/update/:identificador',
    component: UpdateComponent
  },
  {
    path: 'fornecedores/update/:identificador',
    component: UpdatefornecedoresComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
