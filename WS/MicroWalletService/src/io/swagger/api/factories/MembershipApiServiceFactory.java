package io.swagger.api.factories;

import io.swagger.api.MembershipApiService;
import io.swagger.api.impl.MembershipApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-07-18T17:40:34.896Z")
public class MembershipApiServiceFactory {
    private final static MembershipApiService service = new MembershipApiServiceImpl();

    public static MembershipApiService getMembershipApi() {
        return service;
    }
}
