/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.cms.core.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.leviosa.bl.service.CMSService;
import org.hedwig.cms.constants.CMSServicePaths;
import org.dgrf.cms.core.service.utils.JSONParseAndDBConn;
import org.hedwig.cms.dto.TermDTO;

/**
 * REST Web Service
 *
 * @author bhaduri
 */
@Path(CMSServicePaths.TERM_BASE)
public class TermResource {

    @Context
    private UriInfo context;
    private CMSService cmss;

    /**
     * Creates a new instance of TermResource
     */
    public TermResource() {
        cmss = new CMSService();
    }

    /**
     * Retrieves representation of an instance of
     * org.dgrf.cms.core.service.TermResource
     *
     * @param termDTOJSON
     * @return an instance of java.lang.String
     */
    @Path(CMSServicePaths.GET_TERM_DETAILS)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getTermDetails(String termDTOJSON) {
        TermDTO termDTO = (TermDTO) JSONParseAndDBConn.authCreateDB(termDTOJSON, TermDTO.class);
        termDTO = cmss.getTermDetails(termDTO);
        return JSONParseAndDBConn.getDTOJSON(termDTO);

    }

    /**
     * Retrieves representation of an instance of
     * org.dgrf.cms.core.service.TermResource
     *
     * @param termDTOJSON
     * @return an instance of java.lang.String
     */
    @Path(CMSServicePaths.GET_ROOT_TERM_LIST)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getRootTermList(String termDTOJSON) {
        TermDTO termDTO = (TermDTO) JSONParseAndDBConn.authCreateDB(termDTOJSON, TermDTO.class);
        termDTO = cmss.getRootTermList(termDTO);
        return JSONParseAndDBConn.getDTOJSON(termDTO);

    }

    /**
     * Retrieves representation of an instance of
     * org.dgrf.cms.core.service.TermResource
     *
     * @param termDTOJSON
     * @return an instance of java.lang.String
     */
    @Path(CMSServicePaths.GET_CHILD_TERM_LIST)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getChildTermList(String termDTOJSON) {
        TermDTO termDTO = (TermDTO) JSONParseAndDBConn.authCreateDB(termDTOJSON, TermDTO.class);
        termDTO = cmss.getChildTermList(termDTO);
        return JSONParseAndDBConn.getDTOJSON(termDTO);
    }

    
}
