package com.userservice.servicemethods;

import com.userservice.entities.User;

import java.util.List;

public interface UserServiceMethods {
    User getSingleUser(String id);
    List<User> getAllUsers();
    User createUser(User user);
    User updateUser(String id,User user);
    void deleteUser(String id);
}
