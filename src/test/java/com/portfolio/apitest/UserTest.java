package com.portfolio.apitest;

import com.portfolio.controller.UserController;
import com.portfolio.model.UserModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest extends APITestBase {
    private UserController userController;

    @BeforeClass
    @Override
    public void setUpConfig() {
        super.setUpConfig();
        userController = new UserController(client);
    }

    @Test
    public void getUsersTest(){
        userController.getUsers();
    }

    @Test
    public void createUserTest(){
        userController.createUser(new UserModel("fdsff", "fwefsdfq", 13));
    }
}
