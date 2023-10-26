import { Flavor } from '../flavor/flavor';

export class Product {
    id!: number;
    name!: string;
    description!: string;
    price!: number;
    flavor!: Flavor;
    quantity!: number;
    imageUrl!: string;
    stars!: number;
}
