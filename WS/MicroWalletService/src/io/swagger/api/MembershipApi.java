package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.MembershipApiService;
import io.swagger.api.factories.MembershipApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.MembershipResponse1;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/membership")


@io.swagger.annotations.Api(description = "the membership API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-07-18T17:40:34.896Z")
public class MembershipApi  {
   private final MembershipApiService delegate;

   public MembershipApi(@Context ServletConfig servletContext) {
      MembershipApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("MembershipApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (MembershipApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = MembershipApiServiceFactory.getMembershipApi();
      }

      this.delegate = delegate;
   }

    @GET
    @Path("/{externalReferenceID}/passport")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets a `Wallet` objects.", response = MembershipResponse1.class, tags={ "Wallet APIs", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = MembershipResponse1.class) })
    public Response membershipExternalReferenceIDPassportGet(@ApiParam(value = "externalReference ID",required=true) @PathParam("externalReferenceID") String externalReferenceID
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.membershipExternalReferenceIDPassportGet(externalReferenceID,securityContext);
    }
}
