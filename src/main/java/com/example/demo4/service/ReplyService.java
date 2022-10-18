package com.example.demo4.service;

import com.example.demo4.mapper.ReplyMapper;
import com.example.demo4.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {
    @Autowired
    private ReplyMapper replyMapper;

    public List<ReplyVO> replyList(int idx) throws Exception {
        return replyMapper.replyList(idx);
    }
    public void replyWrite(ReplyVO vo) throws Exception {
        replyMapper.replyWrite(vo);
    }
    public void replyUpdate(ReplyVO vo) throws Exception {
        replyMapper.replyUpdate(vo);
    }
    public void replyDelete(ReplyVO vo) throws Exception {
        replyMapper.replyDelete(vo);
    }
}
