package com.github.fabriciolfj.entrypoint.controller;

import com.github.fabriciolfj.business.usecase.FindAccount;
import com.github.fabriciolfj.entrypoint.dto.converter.ExtractResponseConverter;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Tag(name = "Extracts", description = "Group de api para criação e manipulacao de extratos")
@RequiredArgsConstructor
@Path("/api/v1/extracts")
public class ExtractController {

    private final FindAccount findAccount;

    @GET
    @Path("{account}")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Busca ultimo extrato da conta"),
            @APIResponse(responseCode = "422", description = "Conta não possui extrato")})
    public Response findLast(@PathParam("account") final String account) {
        var extract = findAccount.execute(account)
                .findExtractFirst();

        return Response.accepted()
                .entity(ExtractResponseConverter.toResponse(extract))
                .build();
    }
}
