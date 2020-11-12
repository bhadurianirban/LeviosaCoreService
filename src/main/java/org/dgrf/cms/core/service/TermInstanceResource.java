/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.cms.core.service;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.leviosa.bl.service.CMSService;

import org.hedwig.cms.dto.TermInstanceDTO;
import org.hedwig.cms.constants.CMSServicePaths;
import org.dgrf.cms.core.service.utils.JSONParseAndDBConn;

/**
 * REST Web Service
 *
 * @author bhaduri
 */
@Path(CMSServicePaths.TERM_INSTANCE_BASE)
public class TermInstanceResource {

    @Context
    private UriInfo context;
    CMSService cmss;
    /**
     * Creates a new instance of TerminstanceService
     */
    public TermInstanceResource() {
        cmss = new CMSService();
    }

    /**
     * Retrieves representation of an instance of
     * org.dgrf.cms.core.service.TerminstanceService
     *
     * @param termInstanceDTOJSON
     * @return an instance of java.lang.String
     */
    @Path(CMSServicePaths.GET_TERM_INSTANCE)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getTermInstance(String termInstanceDTOJSON) {
        TermInstanceDTO termInstanceDTO = (TermInstanceDTO)JSONParseAndDBConn.authCreateDB(termInstanceDTOJSON,TermInstanceDTO.class);
        termInstanceDTO = cmss.getTermInstance(termInstanceDTO);
        return JSONParseAndDBConn.getDTOJSON(termInstanceDTO);
        
    }
   /**
     * Retrieves representation of an instance of
     * org.dgrf.cms.core.service.TerminstanceService.
     * Response code is 0 if term instance slug exists.
     *
     * @param termInstanceDTOJSON
     * @return an instance of java.lang.String
     */
    @Path(CMSServicePaths.IS_TERM_INSTANCE_EXISTS)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String termInstanceSlugExists(String termInstanceDTOJSON) {
        TermInstanceDTO termInstanceDTO = (TermInstanceDTO)JSONParseAndDBConn.authCreateDB(termInstanceDTOJSON,TermInstanceDTO.class);
        termInstanceDTO = cmss.isExistsTermInstanceSlug(termInstanceDTO);
        return JSONParseAndDBConn.getDTOJSON(termInstanceDTO);
    }
    /**
     * Retrieves representation of an instance of
     * org.dgrf.cms.core.service.TerminstanceService
     *
     * @param termInstanceDTOJSON
     * @return an instance of java.lang.String
     */
    @Path(CMSServicePaths.GET_TERM_INSTANCE_LIST)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getTermInstanceList(String termInstanceDTOJSON) {
        TermInstanceDTO termInstanceDTO = (TermInstanceDTO)JSONParseAndDBConn.authCreateDB(termInstanceDTOJSON,TermInstanceDTO.class);
        termInstanceDTO = cmss.getTermInstanceList(termInstanceDTO);
        return JSONParseAndDBConn.getDTOJSON(termInstanceDTO);
    }
    /**
     * Retrieves representation of an instance of
     * org.dgrf.cms.core.service.TerminstanceService
     *
     * @param termInstanceDTOJSON
     * @return an instance of java.lang.String
     */
    @Path(CMSServicePaths.GET_CHILD_TERM_INSTANCE_LIST)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getChildTermInstanceList(String termInstanceDTOJSON) {
        TermInstanceDTO termInstanceDTO = (TermInstanceDTO)JSONParseAndDBConn.authCreateDB(termInstanceDTOJSON,TermInstanceDTO.class);
        termInstanceDTO = cmss.getChildTermInstanceList(termInstanceDTO);
        return JSONParseAndDBConn.getDTOJSON(termInstanceDTO);
    }

    /**
     * Retrieves representation of an instance of
     * org.dgrf.cms.core.service.TerminstanceService
     *
     * @param termInstanceDTOJSON
     * @return an instance of java.lang.String
     */
    @Path(CMSServicePaths.SAVE_TERM_INSTANCE)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String saveTermInstance(String termInstanceDTOJSON) {
        TermInstanceDTO termInstanceDTO = (TermInstanceDTO)JSONParseAndDBConn.authCreateDB(termInstanceDTOJSON,TermInstanceDTO.class);
        termInstanceDTO = cmss.saveTermInstance(termInstanceDTO);
        return JSONParseAndDBConn.getDTOJSON(termInstanceDTO);
    }

    @Path(CMSServicePaths.DELETE_TERM_INSTANCE)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteTermInstance(String termInstanceDTOJSON) {
        TermInstanceDTO termInstanceDTO = (TermInstanceDTO)JSONParseAndDBConn.authCreateDB(termInstanceDTOJSON,TermInstanceDTO.class);
        termInstanceDTO = cmss.deleteTermInstance(termInstanceDTO);
        return JSONParseAndDBConn.getDTOJSON(termInstanceDTO);
    }
    @Path(CMSServicePaths.INIT_MEDIA_TERM_INSTANCE)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createMediaTermInstance(String termInstanceDTOJSON) {
        TermInstanceDTO termInstanceDTO = (TermInstanceDTO)JSONParseAndDBConn.authCreateDB(termInstanceDTOJSON,TermInstanceDTO.class);
        termInstanceDTO = cmss.addMedia(termInstanceDTO);
        return JSONParseAndDBConn.getDTOJSON(termInstanceDTO);
    }

}
