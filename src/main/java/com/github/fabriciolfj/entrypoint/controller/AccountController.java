package com.github.fabriciolfj.entrypoint.controller;

import com.github.fabriciolfj.business.usecase.CreateAccount;
import com.github.fabriciolfj.business.usecase.FindAccount;
import com.github.fabriciolfj.entrypoint.dto.converter.AccountRequestConverter;
import com.github.fabriciolfj.entrypoint.dto.converter.AccountResponseConverter;
import com.github.fabriciolfj.entrypoint.dto.request.AccountRequest;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final CreateAccount createAccount;
    private final FindAccount findAccount;

    @POST
    public Response create(final AccountRequest request) {
        var account = AccountRequestConverter.toEntity(request);
        var response = AccountResponseConverter.toResponse(createAccount.execute(account));

        return Response.accepted(response).build();
    }

    @GET
    @Path("{code}")
    public Response find(@PathParam("code") final String code) {
        var response = AccountResponseConverter.toResponse(findAccount.execute(code));

        return Response.accepted(response).build();
    }
}