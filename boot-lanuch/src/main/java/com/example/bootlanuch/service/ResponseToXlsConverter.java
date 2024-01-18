package com.example.bootlanuch.service;

import com.example.bootlanuch.AjaxResponse;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ResponseToXlsConverter extends AbstractHttpMessageConverter<AjaxResponse> {
    @Override
    protected boolean supports(Class<?> clazz) {
        return (AjaxResponse.class == clazz);
    }

    @Override
    protected AjaxResponse readInternal(Class<? extends AjaxResponse> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(AjaxResponse ajaxResponse, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

    }
}
