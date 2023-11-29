package com.pizzeria.MammaMia.Entity;

import jakarta.persistence.*;

@Entity
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String Tamanho;
    private Integer Nsabor;

    private Integer Npedacos;

    public Size(Long id, String tamanho, Integer nsabor, Integer npedacos) {
        this.id = id;
        Tamanho = tamanho;
        Nsabor = nsabor;
        Npedacos = npedacos;
    }

    public Integer getNpedacos() {
        return Npedacos;
    }

    public void setNpedacos(Integer npedacos) {
        Npedacos = npedacos;
    }

    public Size() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTamanho() {
        return Tamanho;
    }

    public void setTamanho(String tamanho) {
        Tamanho = tamanho;
    }

    public Integer getNsabor() {
        return Nsabor;
    }

    public void setNsabor(Integer nsabor) {
        Nsabor = nsabor;
    }
}
