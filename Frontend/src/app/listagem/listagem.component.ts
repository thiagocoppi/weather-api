import { ToastrService } from 'ngx-toastr';
import { ListagemService } from './listagem.service';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { Cidades } from '../cadastro/cadastro.model';

@Component({
  selector: 'app-listagem',
  templateUrl: './listagem.component.html',
  styleUrls: ['./listagem.component.css']
})
export class ListagemComponent implements OnInit {

  constructor(private listagemService: ListagemService,
              private toastr: ToastrService) { }

  ngOnInit() {
    this.buscarTodasCidades();
  }

  listaCidades: Cidades[] = [];

  public buscarTodasCidades(): void{
    this.listagemService.buscarTodasCidades().subscribe(res => {
      this.listaCidades = res;
    }, error => {
      this.toastr.error('Ocorreu um erro ao listar as cidades', 'Cidades');
    })
    
  }

  public removercidade(id: number): void {
    this.listagemService.removerCidade(id).subscribe(res => {
      this.toastr.success('Cidade removida com sucesso !', 'Cidade');
      this.buscarTodasCidades();
    });
  }

}
