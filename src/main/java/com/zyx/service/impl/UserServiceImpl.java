package com.zyx.service.impl;

import com.zyx.dao.UserMapper;
import com.zyx.model.User;
import com.zyx.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Ethel_oo on 2017/12/6.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.selectAll();
    }
}
