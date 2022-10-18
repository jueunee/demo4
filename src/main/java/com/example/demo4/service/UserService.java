package com.example.demo4.service;

import com.example.demo4.dto.UserDTO;
import com.example.demo4.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createUser(UserDTO userDTO) {
        userMapper.createUser(userDTO);
    }

    public List<UserDTO> login(UserDTO userDTO) {
        List<UserDTO> result = userMapper.login(userDTO);
        return result;
    }
    public int overlappedID(String id) throws Exception {
        int result = userMapper.overlappedID(id);
        return result;
    }



}
