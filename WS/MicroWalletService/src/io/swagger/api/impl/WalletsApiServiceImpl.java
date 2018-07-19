package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.WalletRequest1;
import io.swagger.model.WalletRequest2;
import io.swagger.model.WalletResponse1;
import io.swagger.model.WalletsResponse1;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-07-18T17:40:34.896Z")
public class WalletsApiServiceImpl extends WalletsApiService {
    @Override
    public Response walletsExternalReferenceIDCardsDelete(String externalReferenceID, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response walletsExternalReferenceIDCardsGet(String externalReferenceID, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response walletsExternalReferenceIDCardsPost(WalletRequest2 wallet, String externalReferenceID, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response walletsExternalReferenceIDCardsWalletIdDelete(String externalReferenceID, String walletId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response walletsExternalReferenceIDCardsWalletIdGet(String externalReferenceID, String walletId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response walletsExternalReferenceIDCardsWalletIdPut(WalletRequest1 wallet, String externalReferenceID, String walletId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
