/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leviosa.core.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.leviosa.bl.service.CMSService;
import org.hedwig.cms.constants.CMSServicePaths;
import org.leviosa.core.service.utils.JSONParseAndDBConn;
import org.hedwig.cms.dto.MediaDTO;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 * REST Web Service
 *
 * @author dgrfiv
 */
@Path(CMSServicePaths.MEDIA_BASE)
public class MediaResource {

    @Context
    private UriInfo context;
    private   String UPLOAD_FOLDER;
    private CMSService cmss;

    public MediaResource() {
        cmss = new CMSService();
    }
    
    
    @Path(CMSServicePaths.UPLOAD_MEDIA)
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA})
    @Produces(MediaType.TEXT_PLAIN)
    public String uploadFile(@FormDataParam("uploadfile") InputStream uploadedInputStream,
            @FormDataParam("uploadfile") FormDataContentDisposition fileDetail,
            @FormDataParam("mediaDTO") String mediaDTOJSON) throws IOException {
        
        UPLOAD_FOLDER = System.getProperty("user.dir") + File.separator;
        

        // check if all form parameters are provided
        if (uploadedInputStream == null || fileDetail == null) {
            return null;
        }
        String uploadedFileLocation = UPLOAD_FOLDER + fileDetail.getFileName();
        
        OutputStream out = null;
        try {
            int read = 0;
            byte[] bytes = new byte[2048];
            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            return null;
        }
        MediaDTO mediaDTO = (MediaDTO) JSONParseAndDBConn.authCreateDB(mediaDTOJSON, MediaDTO.class);
        mediaDTO.setMediaFilePath(uploadedFileLocation);
        mediaDTO = cmss.uploadMedia(mediaDTO);
        return JSONParseAndDBConn.getDTOJSON(mediaDTO);
        
        
    }
    @Path(CMSServicePaths.DELETE_MEDIA)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteMedia(String mediaDTOJSON) {
        MediaDTO mediaDTO = (MediaDTO) JSONParseAndDBConn.authCreateDB(mediaDTOJSON, MediaDTO.class);
        mediaDTO = cmss.deleteMedia(mediaDTO);
        return JSONParseAndDBConn.getDTOJSON(mediaDTO);
        
    }
}
