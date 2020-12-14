/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leviosa.core.service.utils;

import org.hedwig.cloud.client.DataConnClient;
import org.hedwig.cloud.dto.DataConnDTO;
import org.hedwig.cloud.dto.HedwigAuthCredentials;

/**
 *
 * @author bhaduri
 */
public class CMSAuthentication {

    public static DataConnDTO authenticateSubcription(HedwigAuthCredentials authCredentials) {

        DataConnClient dataConnClient = new DataConnClient(authCredentials.getHedwigServer(),authCredentials.getHedwigServerPort());
        DataConnDTO dataConnDTO = new DataConnDTO();
        dataConnDTO.setCloudAuthCredentials(authCredentials);
        dataConnDTO = dataConnClient.getDataConnParams(dataConnDTO);
        return dataConnDTO;
    }
}
