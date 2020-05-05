package com.portfolio.controller;

import io.restassured.specification.RequestSpecification;

public abstract class AbstractController {
    protected RequestSpecification client;

    public AbstractController(RequestSpecification requestSpecification) {
        this.client = requestSpecification;
    }
}
