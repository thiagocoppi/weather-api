import { CardService } from './card.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Card } from './card.model';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  cardRet: Card;

  constructor(private cardService: CardService,
              private router: ActivatedRoute) { }


    
  ngOnInit() {
    let cidade: string = this.router.snapshot.params['nome'];
    
    if (cidade) {
      this.cardService.findForecastByCity(cidade).subscribe(res => {
        this.cardRet = res;
        console.log(this.cardRet);
      });
    }
  }

  public findForecastByCity(cidade: string){


  }

}
