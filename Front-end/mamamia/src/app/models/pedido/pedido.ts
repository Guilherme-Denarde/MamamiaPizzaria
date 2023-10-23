import { Produto } from "../produto/produto";

export class Pedido {
    id!: number;
    obs!: string;
    produtos!: Produto[];
}
