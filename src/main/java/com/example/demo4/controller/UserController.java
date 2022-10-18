package com.example.demo4.controller;

import com.example.demo4.dto.UserDTO;
import com.example.demo4.mapper.UserMapper;
import com.example.demo4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    UserMapper userMapper;

    @RequestMapping("/signupPage")
    public String page() throws Exception {
        return "signUp";
    }

    @RequestMapping(value = "/signup")
    public String postSignup(UserDTO userDTO)  {
        System.out.println(userDTO);
        userService.createUser(userDTO);
//        model.addAttribute("msg", "회원가입 완료");
        return "/index";
    }
    /**
     * 아이디 중복 확인
     */
    @ResponseBody
    @GetMapping("/idCheck") // 아이디 중복확인을 위한 값으로 따로 매핑
    public int overlappedID(String id) throws Exception {
        int result = userService.overlappedID(id); // 중복확인한 값을 int로 받음
        return result;
    }

    /*
     * 로그인 정보 일치 확인
     * 차단된 유저들 로그인 정지
     */
    @PostMapping("/index")
    public ModelAndView getSelectOne(UserDTO userDTO, HttpSession session) throws Exception {
        List<UserDTO> result = userService.login(userDTO);
        ModelAndView mav = new ModelAndView();
        if (result.size() != 0) {
            // 로그인성공시 세션을 생성
            session.setAttribute("member", result.get(0));
            // 세션에 로그인된 회원 인증성공 시 채팅페이지 이동
            mav.setViewName("redirect:/board/list");
            return mav;
        } else {
            mav.setViewName("/index");
            mav.addObject("msg", "failure");
            return mav;
        }
    }

    /*
     * 로그아웃, 세션 초기화
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) throws Exception {
        session.invalidate();
        return "/index";
    }

}
