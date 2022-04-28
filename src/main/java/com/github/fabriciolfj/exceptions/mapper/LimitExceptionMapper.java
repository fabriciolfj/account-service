package com.github.fabriciolfj.exceptions.mapper;

import com.github.fabriciolfj.exceptions.LimitException;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.ws.rs.core.Response;

public class LimitExceptionMapper implements ResponseExceptionMapper<LimitException> {

    @Override
    public LimitException toThrowable(Response response) {
        return new LimitException("Fail to retrieve, details: " + response.getEntity());
    }
}
