/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maria.moto;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.faces.annotation.FacesConfig;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ferna
 */
@Dependent
@FacesConfig
public class Config {
  @Produces
  @PersistenceContext
  EntityManager em;
}