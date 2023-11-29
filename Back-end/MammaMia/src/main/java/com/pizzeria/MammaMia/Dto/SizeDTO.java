package com.pizzeria.MammaMia.Dto;

public class SizeDTO {


    private String Tamanho;
    private Integer Nsabor;
    private Integer Npedacos;

    public SizeDTO(String tamanho, Integer nsabor, Integer npedacos) {

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
