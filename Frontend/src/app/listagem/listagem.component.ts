import { ListagemService } from './listagem.service';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { Cidades } from '../cadastro/cadastro.model';

@Component({
  selector: 'app-listagem',
  templateUrl: './listagem.component.html',
  styleUrls: ['./listagem.component.css']
})
export class ListagemComponent implements OnInit {

  constructor(private listagemService: ListagemService) { }

  ngOnInit() {
    this.buscarTodasCidades();
  }

  listaCidades: Cidades[] = [];

  public buscarTodasCidades(): void{
    try {
      this.listagemService.buscarTodasCidades().subscribe(res => {
        this.listaCidades = res;
      })
    } catch {
      console.log('Ocorreu um erro ao realizar a requisição das cidades');
    }
  }

  public removercidade(id: number): void {
    this.listagemService.removerCidade(id).subscribe(res => {
      this.buscarTodasCidades();
    });
  }

}
