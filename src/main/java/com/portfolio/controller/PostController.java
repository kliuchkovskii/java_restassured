package com.portfolio.controller;

import com.portfolio.model.PostModel;
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

    public Response createPost(PostModel body){
        return given(this.client).body(body).post(BASE_ENDPOINT);
    }
}
