package application;

import entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        /*
        Ler os dados de um pedido com N itens (N fornecido pelo usuário). Depois,
        mostrar um sumário do pedido. O instante do pedido deve ser o instante do sistema
        "new Date()
         */


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Insira os dados do cliente:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Data de nascimento (DD/MM/YYYY): ");
        LocalDate dataDeNascimento = LocalDate.parse(sc.next(), dtf);

        Cliente cliente = new Cliente(nome, email, dataDeNascimento);

        System.out.println();
        System.out.println("Insira os dados do pedido:");
        System.out.print("Status: ");
        StatusDoPedido status = StatusDoPedido.valueOf(sc.next());
        System.out.print("Quantos itens há nesse pedido? ");
        int n = sc.nextInt();

        Pedido pedido = new Pedido(LocalDateTime.now(), status, cliente);

        for (int i = 0; i < n; i++) {
            System.out.println("Insira os dados do pedido #" + (i + 1) + ": ");
            System.out.print("Nome do produto: ");
            sc.nextLine();
            String nomeDoProduto = sc.nextLine();
            System.out.print("Preço do produto: ");
            double precoProduto = sc.nextDouble();
            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();

            Produto produto = new Produto(nomeDoProduto, precoProduto);

            ItemDoPedido itens = new ItemDoPedido(quantidade, precoProduto, produto);

            pedido.addItem(itens);
        }

        System.out.println();
        System.out.println(pedido);

        sc.close();
    }
}