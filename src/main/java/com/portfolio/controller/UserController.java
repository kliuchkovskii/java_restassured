package com.portfolio.controller;

import com.portfolio.model.UserModel;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserController extends AbstractController{
    private static final String BASE_ENDPOINT = "/user";

    public UserController(RequestSpecification requestSpecification){
        super(requestSpecification);
    }

    public Response getUsers(){
        return given(this.client).get("/users");
    }

    public Response createUser(UserModel body){
        return given(this.client).body(body).post(BASE_ENDPOINT);
    }
}
