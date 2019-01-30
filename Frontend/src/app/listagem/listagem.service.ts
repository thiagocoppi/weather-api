import { API_URL } from './../app.api';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Cidades } from '../cadastro/cadastro.model';

@Injectable({
  providedIn: 'root'
})
export class ListagemService {

  constructor(private http: HttpClient) { }

  public buscarTodasCidades(): Observable<Cidades[]> {
    return this.http.get<Cidades[]>(`${API_URL}cidade/all`);
  }

  public removerCidade(id: number): Observable<void> {
    return this.http.delete<void>(`${API_URL}cidade?id=${id}`);
  }
}
