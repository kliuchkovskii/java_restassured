package com.portfolio.client;

import com.portfolio.util.ConfigurationManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;

public class HttpClientBuilder {
    private RequestSpecBuilder clientBuilder;

    private HttpClientBuilder() {
        this.clientBuilder = new RequestSpecBuilder();
    }

    public static RequestSpecification buildDefaultClient(){
        return HttpClientBuilder.getInstance()
                .withBasePath(ConfigurationManager.props().basePath())
                .withBaseUrl(ConfigurationManager.props().baseUrl())
                .withDefaultFilters()
                .withContentType(ContentType.JSON)
                .build();
    }

    public static HttpClientBuilder getInstance() {
        return new HttpClientBuilder();
    }

    public HttpClientBuilder withBaseUrl(String baseUrl) {
        this.clientBuilder.setBaseUri(baseUrl);
        return this;
    }

    public HttpClientBuilder withBasePath(String basePath) {
        this.clientBuilder.setBasePath(basePath);
        return this;
    }

    public HttpClientBuilder withContentType(ContentType contentType) {
        this.clientBuilder.setContentType(contentType);
        return this;
    }

    public HttpClientBuilder withDefaultFilters() {
        this.clientBuilder.addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter()));
        return this;
    }

    public RequestSpecification build() {
        return this.clientBuilder.build();
    }
}
