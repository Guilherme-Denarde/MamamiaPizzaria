import { Client } from "../client/client";
import { DeliveryPeople } from "../deliveryPeople/delivery-people";
import { Employ } from "../employ/employ";

export enum Payment {
    PIX = 'pix',
    CARD = 'card',
    MONEY = 'money',
    CHECK = 'check'
}

export enum OrderSize {
    P = 'p',
    M = 'm',
    G = 'g',
    GG = 'gg'
}

export enum OrderState {
    OPEN = 'open',
    MAKING = 'making',
    FINISHED = 'finished',
    CANCELED = 'canceled'
}

export class Order {
    id?: number;
    payment?: Payment;
    orderSize?: OrderSize;
    orderState?: OrderState;
    mustDeliver?: boolean;
    orderTime?: Date;
    deliveryTime?: Date;
    priceTotal?: number;
    deliveryPeople?: DeliveryPeople;
    client?: Client;
    employ?: Employ;
}
