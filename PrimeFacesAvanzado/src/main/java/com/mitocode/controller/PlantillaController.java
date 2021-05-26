package com.mitocode.controller;

import com.mitocode.model.Usuario;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PlantillaController implements Serializable{
    public void verificarSesion(){
        Usuario us;
        try{
            
            FacesContext context = FacesContext.getCurrentInstance();
            us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
            if (us==null){
                context.getExternalContext().redirect("./../permisos.xhtml");
            }
        } catch (Exception e) {
            
        }
    }
}
