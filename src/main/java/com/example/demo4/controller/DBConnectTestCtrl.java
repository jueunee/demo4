//package com.example.demo4.controller;
//
//
//import com.example.demo4.dto.TestDTO;
//import com.example.demo4.repository.TestDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class DBConnectTestCtrl {
//
//    @Autowired
//    private TestDAO testDAO;
//
//    @GetMapping("/hello")
//    public List<TestDTO> HelloWorld() {
//        return testDAO.getTestData();
//    }
//}