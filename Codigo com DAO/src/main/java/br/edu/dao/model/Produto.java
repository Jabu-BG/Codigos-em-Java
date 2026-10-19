package br.edu.dao.model;

import java.util.Objects;

/**
 * Entidade de domínio persistida na tabela produto.
 */
public class Produto {
    private long id;
    private String nome;
    private double preco;
    private int estoque;

    public Produto() {
    }

    public Produto(String nome, double preco, int estoque) {
        this(0, nome, preco, estoque);
    }

    public Produto(long id, String nome, double preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + String.format(java.util.Locale.US, "%.2f", preco) +
                ", estoque=" + estoque +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return id == produto.id &&
                Double.compare(preco, produto.preco) == 0 &&
                estoque == produto.estoque &&
                Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, preco, estoque);
    }
}
