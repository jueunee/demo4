package com.example.demo4.repository;

import com.example.demo4.dto.TestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestDAO {
    List<TestDTO> getTestData();
}
