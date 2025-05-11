package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String nome;
    private String email;
    private LocalDate dataDeNascimento;

    public Cliente(String nome, String email, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDiaAniversario() {
        return dataDeNascimento;
    }

    public void setDiaAniversario(LocalDate diaAniversario) {
        this.dataDeNascimento = diaAniversario;
    }

    @Override
    public String toString() {
        return   nome
                + " ("
                + dtf.format(dataDeNascimento)
                + ") - "
                + email;

    }
}
