import { API_URL } from './../app.api';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cidades } from './cadastro.model';

@Injectable({
  providedIn: 'root'
})
export class CadastroService {

  constructor(private http: HttpClient) { }

  public salvarCidade(cidade: Cidades): Observable<Cidades> {
    try {
      return this.http.post<Cidades>(API_URL + 'cidade', cidade);
    } catch {
      console.log('Ocorreu um erro ao realizar o salvamento da cidade.');
    }
  }

  public findById(id: number): Observable<Cidades> {
    return this.http.get<Cidades>(`${API_URL}cidade?id=${id}`);
  }

  public editarCidade(cidade: Cidades): Observable<Cidades> {
    return this.http.put<Cidades>(`${API_URL}cidade`, cidade);
  }
}
