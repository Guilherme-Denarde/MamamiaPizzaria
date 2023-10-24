import { Flavor } from '../flavor/flavor';

export interface Product {
    id: number;
    name: string;
    description: string;
    price: number;
    flavor: Flavor;
    quantity: number;
}
