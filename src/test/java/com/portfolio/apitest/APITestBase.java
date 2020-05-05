package com.portfolio.apitest;

import com.portfolio.client.HttpClientBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class APITestBase {
    protected RequestSpecification client;

    @BeforeClass
    public void setUpConfig() {
        this.client = HttpClientBuilder.buildDefaultClient();
    }
}
