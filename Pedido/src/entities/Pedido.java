package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private LocalDateTime momento;
    private StatusDoPedido status;

    private Cliente cliente;

    private List<ItemDoPedido> itens = new ArrayList<>();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Pedido(LocalDateTime momento, StatusDoPedido status, Cliente cliente) {
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;
    }

    public LocalDateTime getMomento() {
        return momento;
    }

    public void setMomento(LocalDateTime momento) {
        this.momento = momento;
    }

    public StatusDoPedido getStatus() {
        return status;
    }

    public void setStatus(StatusDoPedido status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public void addItem(ItemDoPedido item) {
        itens.add(item);
    }
    public void removeItem(ItemDoPedido item) {
        itens.remove(item);
    }


    public double total() {

        double sum = 0;

        for (ItemDoPedido item : itens) {
            sum += item.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Momento do pedido: ");
        sb.append(dtf.format(momento) + "\n");
        sb.append("Status do pedido: ");
        sb.append(status + "\n");
        sb.append("Cliente: ");
        sb.append(cliente + "\n");
        sb.append("Itens do pedido: \n");

        for (ItemDoPedido item : itens) {
            sb.append(item + "\n");
        }

        sb.append("Preço total: $");
        sb.append(String.format("%.2f", total()));

        return sb.toString();
    }
}
