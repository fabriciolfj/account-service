package com.github.fabriciolfj.entrypoint.controller;

import com.github.fabriciolfj.business.usecase.CreateAccount;
import com.github.fabriciolfj.business.usecase.FindAccount;
import com.github.fabriciolfj.entrypoint.dto.converter.AccountRequestConverter;
import com.github.fabriciolfj.entrypoint.dto.converter.AccountResponseConverter;
import com.github.fabriciolfj.entrypoint.dto.request.AccountRequest;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.CREATED;

@Path("/api/v1/accounts")
@Tag(name = "Accounts", description = "Group de api para criação e manipulacao de contas")
@RequiredArgsConstructor
public class AccountController {

    private final CreateAccount createAccount;
    private final FindAccount findAccount;

    @POST
    @Operation(description = "Criação da conta")
    @APIResponses(
	value = {@APIResponse(responseCode = "201", description = "Conta criada com sucesso"),
        @APIResponse(responseCode = "422", description = "Erro na criação da conta")})
    public Response create(final AccountRequest request) {
        var account = AccountRequestConverter.toEntity(request);
        var response = AccountResponseConverter.toResponse(createAccount.execute(account));

        return Response.status(CREATED).entity(response).build();
    }

    @GET
    @Path("{code}")
    @Operation(description = "Busca da conta")
    @APIResponses(
            value = {@APIResponse(responseCode = "202", description = "Criada retornada com sucesso"),
                    @APIResponse(responseCode = "404", description = "Conta não encontrada")})
    public Response find(@PathParam("code") final String code) {
        var response = AccountResponseConverter.toResponse(findAccount.execute(code));

        return Response.accepted(response).build();
    }
}