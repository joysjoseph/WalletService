package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.WalletsApiService;
import io.swagger.api.factories.WalletsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;
import java.sql.SQLException;
import java.time.ZonedDateTime;

import org.codehaus.jackson.annotate.JsonWriteNullProperties;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.flowers.es.wallet.uril.DBUtil;
import com.flowers.es.wallet.uril.WalletUtil;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/wallets")

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@io.swagger.annotations.Api(description = "the wallets API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-07-18T17:40:34.896Z")
public class WalletsApi  {
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
   private final WalletsApiService delegate;

   public WalletsApi(@Context ServletConfig servletContext) {
      WalletsApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("WalletsApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (WalletsApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = WalletsApiServiceFactory.getWalletsApi();
      }

      this.delegate = delegate;
   }

    @DELETE
    @Path("/{externalReferenceID}/cards")
    
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "Delete all wallets attached to contact id.", response = void.class, tags={ "Wallet APIs", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "No Content", response = void.class) })
    public Response walletsExternalReferenceIDCardsDelete(@ApiParam(value = "externalReference ID",required=true) @PathParam("externalReferenceID") String externalReferenceID
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.walletsExternalReferenceIDCardsDelete(externalReferenceID,securityContext);
    }
    @GET
    @Path("/{externalReferenceID}/cards")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets `Wallet` objects.", response = WalletsResponse1.class, tags={ "Wallet APIs", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = WalletsResponse1.class) })
    public Response walletsExternalReferenceIDCardsGet(@ApiParam(value = "externalReference ID",required=true) @PathParam("externalReferenceID") String externalReferenceID
,@Context SecurityContext securityContext)
    throws NotFoundException {
        //return Response.ok().entity("magic!").build();
    	//@JsonInclude(JsonInclude.Include.NON_NULL)
    	ZonedDateTime first = ZonedDateTime.now();
    	ZonedDateTime second = null;
    	WalletsResponse res = new WalletsResponse();
    	
    	Wallets1 result=null;
		try {
			res = DBUtil.callUSP_GetAccountRefInfo(externalReferenceID);
		} catch (Exception e) {
    		// TODO Auto-generated catch block
    		res = DBUtil.setDefaultWalletsResponseData(null);
			res.setStatusCode(500+"");		
			res = DBUtil.addErrorObjectsToWalletsResponse(res,e.getMessage(),3005,"500");			
    		e.printStackTrace();
    		second = ZonedDateTime.now();
    		String str_ServiceTime= WalletUtil.getProcessTime(first, second);
    		res.setServiceTime(str_ServiceTime);
    		return Response.status(500).entity(res).build();
    	}    	    	
		//res.setResult(result );
		System.out.println("OUT:\n"+res.toString());
		 second = ZonedDateTime.now();
		String str_ServiceTime= WalletUtil.getProcessTime(first, second);
		res.setServiceTime(str_ServiceTime);
    	return Response.ok().entity(res).build();
   }
    @POST
    @Path("/{externalReferenceID}/cards")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    @io.swagger.annotations.ApiOperation(value = "", notes = "Add a single 'Wallet' object.", response = void.class, tags={ "Wallet APIs", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "No Content", response = void.class) })
    public Response walletsExternalReferenceIDCardsPost(@ApiParam(value = "add wallet" ,required=true) WalletRequest2 wallet
,@ApiParam(value = "externalReference ID",required=true) @PathParam("externalReferenceID") String externalReferenceID
,@Context SecurityContext securityContext)
    throws NotFoundException {
    	long start_time;
    	long end_time;
    	long process_time;
    	long wallet_id =0;
    	WalletResponse res = null;
    	ZonedDateTime first = ZonedDateTime.now();
    	ZonedDateTime second = null;
		try {
			res  = DBUtil.callUSP_INSERT_UPDATE_WalletID(externalReferenceID, wallet);
		} catch (Exception e) {
    		// TODO Auto-generated catch block
    		res = DBUtil.setDefaultWalletResponseData(null);
			res.setStatusCode(500+"");	 	
			res = DBUtil.addErrorObjectsToResponse(res,e.getMessage(),3004,"500");			
    		e.printStackTrace();
    		second = ZonedDateTime.now();
    		String str_ServiceTime= WalletUtil.getProcessTime(first, second);
    		res.setServiceTime(str_ServiceTime);
    		return Response.status(500).entity(res).build();
    	}
		second = ZonedDateTime.now();
		String str_ServiceTime= WalletUtil.getProcessTime(first, second);
		res.setServiceTime(str_ServiceTime);
    	return Response.ok().entity(res).build();
    }
    @DELETE
    @Path("/{externalReferenceID}/cards/{walletId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "Delete the wallet with wallet id attached to contact id .", response = WalletResponse1.class, tags={ "Wallet APIs", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "No Content", response = WalletResponse1.class) })
    public Response walletsExternalReferenceIDCardsWalletIdDelete(@ApiParam(value = "externalRefereneID id",required=true) @PathParam("externalReferenceID") String externalReferenceID
,@ApiParam(value = "wallet id to be deleted",required=true) @PathParam("walletId") String walletId
,@Context SecurityContext securityContext)
    throws NotFoundException {
    	WalletResponse res = null;
    	ZonedDateTime first = ZonedDateTime.now();
    	ZonedDateTime second = null;
    	try {
			res = DBUtil.deleteWalletCard(externalReferenceID,walletId);
		} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		res = DBUtil.setDefaultWalletResponseData(null);
			res.setStatusCode(500+"");		
			res = DBUtil.addErrorObjectsToResponse(res,e.getMessage(),3003,"500");			
    		e.printStackTrace();
    		second = ZonedDateTime.now();
    		String str_ServiceTime= WalletUtil.getProcessTime(first, second);
    		res.setServiceTime(str_ServiceTime);
    		return Response.status(500).entity(res).build();
    	}
    	second = ZonedDateTime.now();
		String str_ServiceTime= WalletUtil.getProcessTime(first, second);
		res.setServiceTime(str_ServiceTime);
    	return Response.ok().entity(res).build();
    }
    @GET
    @Path("/{externalReferenceID}/cards/{walletId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets a `Wallet` objects.", response = WalletResponse1.class, tags={ "Wallet APIs", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = WalletResponse1.class) })
    public Response walletsExternalReferenceIDCardsWalletIdGet(@ApiParam(value = "externalReference ID",required=true) @PathParam("externalReferenceID") String externalReferenceID
,@ApiParam(value = "wallet id",required=true) @PathParam("walletId") String walletId
,@Context SecurityContext securityContext)
		throws NotFoundException {

    	ZonedDateTime first = ZonedDateTime.now();
    	ZonedDateTime second = null;
    	WalletResponse res = null;

    	WalletResult1 result;
    	//Wallets1 result=null;
    	try {
    		res = DBUtil.callUSP_GetWalletInfo(externalReferenceID,walletId);
    		//res.setResult(result );
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		res = DBUtil.setDefaultWalletResponseData(null);
			res.setStatusCode(500+"");		
			res = DBUtil.addErrorObjectsToResponse(res,e.getMessage(),3002,"500");			
    		e.printStackTrace();
    		second = ZonedDateTime.now();
    		String str_ServiceTime= WalletUtil.getProcessTime(first, second);
    		res.setServiceTime(str_ServiceTime);
    		return Response.status(500).entity(res).build();
    	}   
    	/*if(res.getStatusCode()!= null && res.getStatusCode().trim().length() >0){
    		int int_status = Integer.parseInt(res.getStatusCode());
    		return Response.status(int_status).entity(res).build();
    	}*/
    	second = ZonedDateTime.now();
		String str_ServiceTime= WalletUtil.getProcessTime(first, second);
		res.setServiceTime(str_ServiceTime);
    	return Response.ok().entity(res).build();
    }
    @PUT
    @Path("/{externalReferenceID}/cards/{walletId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Update a single 'Wallet' object.", response = WalletResponse1.class, tags={ "Wallet APIs", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "No Content", response = WalletResponse1.class) })
    public Response walletsExternalReferenceIDCardsWalletIdPut(@ApiParam(value = "update wallet" ,required=true) WalletRequest1 wallet
,@ApiParam(value = "externalReference ID",required=true) @PathParam("externalReferenceID") String externalReferenceID
,@ApiParam(value = "wallet id",required=true) @PathParam("walletId") String walletId
,@Context SecurityContext securityContext)
		throws NotFoundException {
    	WalletResponse res = null;
    	
    	ZonedDateTime first = ZonedDateTime.now();
    	ZonedDateTime second = null;
    	long wallet_id =0;
    	try {
    		res = DBUtil.callUpdateUSP_INSERT_UPDATE_WalletID(externalReferenceID, wallet);
    		
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		res = DBUtil.setDefaultWalletResponseData(null);
			res.setStatusCode(500+"");		
			res = DBUtil.addErrorObjectsToResponse(res,e.getMessage(),3001,"500");			
    		e.printStackTrace();
    		second = ZonedDateTime.now();
    		String str_ServiceTime= WalletUtil.getProcessTime(first, second);
    		res.setServiceTime(str_ServiceTime);
    		return Response.status(500).entity(res).build();
    	}
    	second = ZonedDateTime.now();
		String str_ServiceTime= WalletUtil.getProcessTime(first, second);
		res.setServiceTime(str_ServiceTime);
    	return Response.ok().entity(res).build();
    	//return delegate.walletsExternalReferenceIDCardsWalletIdPut(wallet,externalReferenceID,walletId,securityContext);
    }
}
