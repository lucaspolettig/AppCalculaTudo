package com.polettiapps.lucaspoletti.math.Model;

public class RecentesModel {

    private Integer _id;
    private Integer id;
    private String nomeCalculadora;
    private String categoria;

    public RecentesModel() {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}


