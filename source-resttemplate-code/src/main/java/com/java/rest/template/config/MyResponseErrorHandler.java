package com.java.rest.template.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-19
 */
@Slf4j
public class MyResponseErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return super.hasError(response);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        HttpStatus statusCode = HttpStatus.resolve(response.getRawStatusCode());
        if (statusCode == null) {
            throw new UnknownHttpStatusCodeException(response.getRawStatusCode(), response.getStatusText(),
                    response.getHeaders(), getResponseBody(response), getCharset(response));
        }
        handleError(response, statusCode);
    }
    @Override
    protected void handleError(ClientHttpResponse response, HttpStatus statusCode) throws IOException {
        switch (statusCode.series()) {
            case CLIENT_ERROR:
                HttpClientErrorException exp1 = new HttpClientErrorException(statusCode, response.getStatusText(), response.getHeaders(), getResponseBody(response), getCharset(response));
                log.error("客户端调用异常",exp1);
                throw  exp1;
            case SERVER_ERROR:
                HttpServerErrorException exp2 = new HttpServerErrorException(statusCode, response.getStatusText(),
                        response.getHeaders(), getResponseBody(response), getCharset(response));
                log.error("服务端调用异常",exp2);
                throw exp2;
            default:
                UnknownHttpStatusCodeException exp3 = new UnknownHttpStatusCodeException(statusCode.value(), response.getStatusText(),
                        response.getHeaders(), getResponseBody(response), getCharset(response));
                log.error("网络调用未知异常");
                throw exp3;
        }
    }

}
