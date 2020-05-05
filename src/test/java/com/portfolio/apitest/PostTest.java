package com.portfolio.apitest;

import com.portfolio.controller.PostController;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PostTest extends APITestBase {
    private PostController postController;

    @BeforeClass
    @Override
    public void setUpConfig() {
        super.setUpConfig();
        postController = new PostController(client);
    }

    @Test
    public void getPostsList(){
        postController.getPostsList();
    }
}
