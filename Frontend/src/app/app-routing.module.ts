import { CardComponent } from './card/card.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListagemComponent } from './listagem/listagem.component';

const routes: Routes = [
  {path: 'cadastrar', component: CadastroComponent},
  {path: 'cadastrar/:id', component: CadastroComponent},
  {path: 'listagem', component: ListagemComponent},
  {path: 'card/:nome', component:CardComponent},
  {path: '', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
