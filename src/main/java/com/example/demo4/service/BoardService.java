package com.example.demo4.service;

import com.example.demo4.mapper.BoardMapper;
import com.example.demo4.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo4.dto.BoardDTO;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public List<BoardDTO> getBoardList(BoardDTO searchVO) {
        List<BoardDTO> result = boardMapper.getBoardList(searchVO);
        return boardMapper.getBoardList(searchVO);
    }
    public void regBoard(BoardDTO searchVO) {
        boardMapper.regBoard(searchVO);
    }
    public BoardDTO detailBoardList(int idx){
        return boardMapper.detailBoardList(idx);
    }

    public void updateBoard(BoardDTO searchVO) {
        boardMapper.updateBoard(searchVO);
    }

    public void getBoardDelete(int idx) {
        boardMapper.getBoardDelete(idx);
    }


    public int getListCnt(BoardDTO searchVO){
        return boardMapper.getListCnt(searchVO);
    }

    public List<BoardDTO> getList(BoardDTO searchVO) {
        return boardMapper.getList(searchVO);
    }


}
