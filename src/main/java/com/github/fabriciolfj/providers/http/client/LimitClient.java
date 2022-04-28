package com.github.fabriciolfj.providers.http.client;

import com.github.fabriciolfj.exceptions.mapper.LimitExceptionMapper;
import com.github.fabriciolfj.providers.http.dto.AccountOverdraftRequest;
import com.github.fabriciolfj.providers.http.dto.AccountOverdraftResponse;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/limits")
@RegisterRestClient(configKey = "limit-service")
@RegisterProvider(LimitExceptionMapper.class)
@RegisterClientHeaders
@Produces(MediaType.APPLICATION_JSON)
public interface LimitClient {

    @PUT
    @Path("overdraft")
    AccountOverdraftResponse find(final AccountOverdraftRequest request);
}
