package com.example.demo4.mapper;

import com.example.demo4.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    public List<ReplyVO> replyList(int idx) throws Exception;
    public void replyWrite(ReplyVO vo) throws Exception;
    public void replyUpdate(ReplyVO vo) throws Exception;
    public void replyDelete(ReplyVO vo) throws Exception;
}
