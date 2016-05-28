package com.polettiapps.lucaspoletti.math.Model;

/**
 * Created by Lucas on 21/05/2016.
 */
public class CalculadoraModel {

    private Integer _id;
    private String nomeCalculadora;
    private String categoria;

    public CalculadoraModel() {

    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getNomeCalculadora() {
        return nomeCalculadora;
    }

    public void setNomeCalculadora(String nomeCalculadora) {
        this.nomeCalculadora = nomeCalculadora;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
