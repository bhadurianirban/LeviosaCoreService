/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leviosa.core.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author bhaduri
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.leviosa.core.service.BheuResource.class);
        resources.add(org.leviosa.core.service.MediaResource.class);
        resources.add(org.leviosa.core.service.MenuResource.class);
        resources.add(org.leviosa.core.service.TermInstanceResource.class);
        resources.add(org.leviosa.core.service.TermMetaResource.class);
        resources.add(org.leviosa.core.service.TermResource.class);
       
    }
    
}
