package com.portfolio.controller;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PostController extends AbstractController{
    private static final String BASE_ENDPOINT = "/posts";

    public PostController(RequestSpecification requestSpecification){
        super(requestSpecification);
    }

    public Response getPostsList(){
        return given(this.client).get(BASE_ENDPOINT);
    }
}
