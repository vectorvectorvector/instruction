package com.instruction.service;


import com.instruction.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    User getUserByPhoneOrEmail(String emailOrPhone);

    User getUserById(Long userId);
}
