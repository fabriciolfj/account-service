package com.github.fabriciolfj.exceptions.handler;

import com.github.fabriciolfj.exceptions.DomainException;
import com.github.fabriciolfj.exceptions.dto.ErrorResponse;
import org.apache.http.HttpStatus;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DomainExceptionHandler implements ExceptionMapper<DomainException> {

    @Override
    public Response toResponse(final DomainException e) {
        return Response.status(HttpStatus.SC_BAD_REQUEST)
                .entity(ErrorResponse.builder().msg(e.getMessage()).build())
                .build();
    }
}
