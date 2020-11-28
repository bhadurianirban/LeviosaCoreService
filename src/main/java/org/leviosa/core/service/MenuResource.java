/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leviosa.core.service;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.leviosa.bl.service.MenuService;
import org.hedwig.cms.constants.CMSServicePaths;
import org.leviosa.core.service.utils.JSONParseAndDBConn;
import org.hedwig.cms.dto.MenuDTO;

/**
 * REST Web Service
 *
 * @author bhaduri
 */
@Path(CMSServicePaths.MENU_BASE)
public class MenuResource {

    @Context
    private UriInfo context;
    MenuService ms;
    /**
     * Creates a new instance of MenuService
     */
    public MenuResource() {
        ms = new MenuService();
    }

    /**
     * Retrieves representation of an instance of
     * org.dgrf.cms.core.service.MenuService
     *
     * @param menuDTOJSON
     * @return an instance of java.lang.String
     */
    @Path(CMSServicePaths.GET_MENU_TREE)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getMenuTree(String menuDTOJSON) {
        MenuDTO menuDTO = (MenuDTO)JSONParseAndDBConn.authCreateDB(menuDTOJSON,MenuDTO.class);
        menuDTO = ms.getMenuTree(menuDTO);
        return JSONParseAndDBConn.getDTOJSON(menuDTO);
        
    }
}
