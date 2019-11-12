/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maria.moto;

import com.maria.web.Mensajes;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ferna
 */
@Named
@ViewScoped
public class CtrlMotoNuevo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private Mensajes mensajes;
    @Inject
    private DaoMoto dao;
    private Moto modelo;

    @PostConstruct
    void init() {
        modelo = new Moto();
    }

    public Moto getModelo() {
        return modelo;
    }

    public String guarda() {
        try {
            dao.agrega(modelo);
            return "index?faces-redirect=true";
        } catch (Exception ex) {
            mensajes.procesa(ex);
            return null;
        }
    }
}
