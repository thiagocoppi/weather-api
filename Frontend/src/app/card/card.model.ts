import { CardDetails } from './card-details.model';


class Card {
    constructor(
        public nomeCidade: number,
        public listaPrevisao: CardDetails[]
    ) {}
}

export { Card }