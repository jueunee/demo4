package com.example.demo4.mapper;

import com.example.demo4.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void createUser(UserDTO userDTO);

    List<UserDTO> login(UserDTO userDTO);
    public int overlappedID(String id) throws Exception;

}
