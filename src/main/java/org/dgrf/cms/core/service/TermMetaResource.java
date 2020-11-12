/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.cms.core.service;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.leviosa.bl.service.CMSService;
import org.hedwig.cms.constants.CMSServicePaths;
import org.hedwig.cms.dto.TermMetaDTO;
import org.dgrf.cms.core.service.utils.JSONParseAndDBConn;

/**
 * REST Web Service
 *
 * @author bhaduri
 */
@Path(CMSServicePaths.TERM_META_BASE)
public class TermMetaResource {
    
    @Context
    private UriInfo context;
    private CMSService cmss;
    /**
     * Creates a new instance of TermMetaResource
     */
    public TermMetaResource() {
        cmss = new CMSService();
    }

    /**
     * Retrieves representation of an instance of
     * org.dgrf.cms.core.service.TermMetaResource
     *
     * @param termMetaDTOJSON
     * @return an instance of java.lang.String
     */
    @Path(CMSServicePaths.GET_TERM_META_LIST)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getTermMeta(String termMetaDTOJSON) {
        TermMetaDTO termMetaDTO = (TermMetaDTO) JSONParseAndDBConn.authCreateDB(termMetaDTOJSON, TermMetaDTO.class);
        termMetaDTO = cmss.getTermMetaList(termMetaDTO);
        return JSONParseAndDBConn.getDTOJSON(termMetaDTO);
    }

        /**
     * Retrieves representation of an instance of
     * org.dgrf.cms.core.service.TermMetaResource
     *
     * @param termMetaDTOJSON
     * @return an instance of java.lang.String
     */
    @Path(CMSServicePaths.GET_CHILD_TERM_META_LIST)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getChildTermMetaList(String termMetaDTOJSON) {
        TermMetaDTO termMetaDTO = (TermMetaDTO) JSONParseAndDBConn.authCreateDB(termMetaDTOJSON, TermMetaDTO.class);
        termMetaDTO = cmss.getChildTermMetaList(termMetaDTO);
        return JSONParseAndDBConn.getDTOJSON(termMetaDTO);
    }

}
