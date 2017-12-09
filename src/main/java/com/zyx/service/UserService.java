package com.zyx.service;

import com.zyx.model.User;

import java.util.List;

/**
 * Created by Ethel_oo on 2017/12/6.
 */
public interface UserService {

    List<User> getUserList();

    User getById(String id);
}
