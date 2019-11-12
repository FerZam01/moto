/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maria.moto;

import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author ferna
 */
@Stateless
@Dependent
public class DaoMoto {

    @Inject
    private EntityManager em;

    public List<Moto> consulta() {
        return em.createQuery("SELECT m FROM Moto m ORDER BY m.marca",
                Moto.class).getResultList();
    }

    public Moto busca(Integer id) {
        return em.find(Moto.class, id);
    }

    public void agrega(Moto modelo) {
        em.persist(modelo);
    }

    public void modifica(Moto modelo) {
        em.merge(modelo);
    }

    public void elimina(Moto modelo) {
        final Moto anterior = em.find(Moto.class, modelo.getId());
        if (anterior != null) {
            em.remove(anterior);
        }
    }
}
