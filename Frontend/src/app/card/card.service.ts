import { API_URL } from './../app.api';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Card } from './card.model';

@Injectable({
  providedIn: 'root'
})
export class CardService {

  constructor(private http: HttpClient) { }

  public findForecastByCity(cidade: string): Observable<Card> {
    try {
      return this.http.get<Card>(`${API_URL}forecast?city=${cidade}`);
    } catch {
      console.log('Não foi possível realizar a requisição para buscar a previsao do tempo');
    }
  }
}
