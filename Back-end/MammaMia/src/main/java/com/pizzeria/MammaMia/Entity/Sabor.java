package com.pizzeria.MammaMia.Entity;


import com.pizzeria.MammaMia.Dto.SaborDTO;
import jakarta.persistence.*;

@Entity
public class Sabor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;


    //algumas pizzarias tem sabores que contam com um adicional de preco
    private Float preco_adicional;


    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    public Sabor() {
    }

    public Sabor(Long id, String nome, Float preco_adicional, String descricao) {
        this.id = id;
        this.nome = nome;
        this.preco_adicional = preco_adicional;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco_adicional() {
        return preco_adicional;
    }

    public void setPreco_adicional(Float preco_adicional) {
        this.preco_adicional = preco_adicional;
    }

    public SaborDTO toDTO() {

        return new SaborDTO(id, nome, preco_adicional, descricao);
    }


}
