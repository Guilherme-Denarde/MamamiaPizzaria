import { Component } from '@angular/core';
import { PedidoService } from '../pedido/pedido.service';
import { Order } from 'src/app/models/orders/orders';
import { OrdersService } from 'src/app/middleware/services/orders/orders.service';
import { Product } from 'src/app/models/product/product';

@Component({
  selector: 'app-pedido-form',
  templateUrl: './pedido-form.component.html',
  styleUrls: ['./pedido-form.component.scss']
})
export class PedidoFormComponent  {

  nome: string | undefined;
  bairro: string | undefined;
  rua: string | undefined;
  numero: string | undefined;
  complemento: string | undefined;
  troco: string | undefined;

 
  pedidos: Order[] = [];
  produtosSelecionados: Product[] = [];
  
  constructor(private pedidoService: PedidoService, private ordersService: OrdersService) {
    this.produtosSelecionados = this.ordersService.getPedidos(); 
  }


  concluirPedido(): void {
    let pedidosTexto = '';

    this.produtosSelecionados.forEach(product => {
      pedidosTexto += `*Produto:* ${product.name}, *Preço:* ${product.price}\n`;
    });

    const total = this.produtosSelecionados.reduce((total, product) => total + product.price, 0);

    const texto = 
      `*Nome:* ${this.nome};\n` +
      `*Bairro:* ${this.bairro};\n` +
      `*Rua:* ${this.rua};\n` +
      `*Número:* ${this.numero};\n` +
      `*Complemento:* ${this.complemento};\n` +
      `*Troco para:* ${this.troco}\n` +
      `*Pedidos:*\n${pedidosTexto}` +
      `*Total Geral:* ${total}\n\n`;

    const textoURI = encodeURIComponent(texto);

    window.open(`https://api.whatsapp.com/send?phone=554535226060&text=${textoURI}${this.pedidoService.pedidoURI}`);
  }
}