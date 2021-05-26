package com.mitocode.controller;

import com.mitocode.ejb.NotaFacadeLocal;
import com.mitocode.model.Nota;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ComentarController implements Serializable{
    
    @EJB
    private NotaFacadeLocal notaEJB;
    
    private List<Nota> notas;
    private Nota nota;
    
    @PostConstruct
    public void init(){
        notas = notaEJB.findAll();
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }
    
    public void asignar(Nota nota){
        this.nota = nota ;
    }
   
}
