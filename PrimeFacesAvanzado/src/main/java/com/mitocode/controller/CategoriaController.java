package com.mitocode.controller;

import com.mitocode.ejb.CategoriaFacadeLocal;
import com.mitocode.model.Categoria;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class CategoriaController implements Serializable{

    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    @Inject
    private Categoria categoria;
    
    @PostConstruct
    public void init() {
        //categoria = new Categoria();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void registrar() {
        try {
            categoriaEJB.create(categoria);
        } catch (Exception e) {
            //mensa prime grwol
        }
    }
}
