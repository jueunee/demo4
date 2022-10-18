package com.example.demo4.mapper;

import com.example.demo4.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    public List<BoardDTO> getBoardList(BoardDTO searchVO);
    public void regBoard(BoardDTO searchVO);
    public BoardDTO detailBoardList(int idx);
    public void updateBoard(BoardDTO searchVO);
    void getBoardDelete(int idx);
    public List<BoardDTO> getList(BoardDTO searchVO);
    public int getListCnt(BoardDTO searchVO);
}
