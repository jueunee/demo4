package com.example.demo4.controller;

import com.example.demo4.dto.BoardDTO;
import com.example.demo4.mapper.ReplyMapper;
import com.example.demo4.service.ReplyService;
import com.example.demo4.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/reply/*")
public class ReplyController {
    @Autowired
    private ReplyService replyService;
    @Autowired
    private ReplyMapper replyMapper;


    @RequestMapping(value = "/reply/write", method = RequestMethod.POST )
    public String postWrite(ReplyVO vo) throws Exception {
        System.out.println("Replyvo : " + vo );
        replyService.replyWrite(vo);
        System.out.println(vo);
        return "redirect:/board/read?idx=" + vo.getIdx();
    }

}
