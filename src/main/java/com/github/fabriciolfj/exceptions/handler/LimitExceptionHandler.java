package com.github.fabriciolfj.exceptions.handler;

import com.github.fabriciolfj.exceptions.LimitException;
import com.github.fabriciolfj.exceptions.dto.ErrorResponse;
import org.apache.http.HttpStatus;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class LimitExceptionHandler implements ExceptionMapper<LimitException> {

    @Override
    public Response toResponse(final LimitException e) {
        return Response.status(HttpStatus.SC_BAD_REQUEST)
                .entity(ErrorResponse.builder().msg(e.getMessage()).build())
                .build();
    }
}
