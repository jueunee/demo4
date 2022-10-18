package com.example.demo4.controller;

import com.example.demo4.dto.BoardDTO;
import com.example.demo4.dto.UserDTO;
import com.example.demo4.service.BoardService;
import com.example.demo4.service.ReplyService;
import com.example.demo4.vo.Pagination;

import com.example.demo4.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private ReplyService replyService;
    /**
     * 게시판 조회페이지
     */
    @RequestMapping(value = "/board/list", method = RequestMethod.GET)
    public String list(@ModelAttribute("searchVO") BoardDTO searchVO, HttpServletRequest request, Model model, HttpSession session) throws UnsupportedEncodingException {
        if(session.getAttribute("member") != null){
            Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
            if(null != inputFlashMap) {
                model.addAttribute("msg",(String) inputFlashMap.get("msg"));

            }

            //페이징[s]
            Pagination pagination = new Pagination();
            pagination.setCurrentPageNo(searchVO.getPageIndex());

            pagination.setRecordCountPerPage(searchVO.getPageUnit());
            pagination.setPageSize(searchVO.getPageSize());

            searchVO.setFirstIndex(pagination.getFirstRecordIndex());
            searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());

            List<BoardDTO> boardList = boardService.getList(searchVO);
            int totCnt = boardService.getListCnt(searchVO);
            pagination.setTotalRecordCount(totCnt);

            searchVO.setEndDate(pagination.getLastPageNoOnPageList());
            searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
            searchVO.setPrev(pagination.getXprev());
            searchVO.setNext(pagination.getXnext());

            model.addAttribute("boardList",boardList);
            model.addAttribute("totCnt",totCnt);
            model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
            model.addAttribute("pagination",pagination);
            //페이징[e]

            System.out.println(model);
            searchVO.setQustr();

            return "/board/list";
        } else {
            return "redirect:/";
        }
    }

    /**
     * 게시판 등록 페이지
     */
    @RequestMapping(value = "/board/create", method = RequestMethod.GET)
    public String create(@ModelAttribute("searchVO") BoardDTO searchVO, Model model) {
        return "/board/create";
    }

    @RequestMapping(value = "/board/create_action", method = RequestMethod.POST)
    public String create_action(@ModelAttribute("searchVO") BoardDTO searchVO, RedirectAttributes redirect) throws UnsupportedEncodingException {
        boardService.regBoard(searchVO);
        redirect.addFlashAttribute("redirect", searchVO.getIdx());

        return "redirect:/board/list";
    }
    /**
     * 게시판 조회/상세 페이지
     */
    @RequestMapping(value = "/board/read", method = RequestMethod.GET)
    public String read(@ModelAttribute("searchVO") BoardDTO searchVO, @RequestParam("idx") int idx, Model model) throws Exception {

        BoardDTO boardContents = boardService.detailBoardList(idx);
        model.addAttribute("boardContents", boardContents);

        searchVO.setQustr();

        List<ReplyVO> reply = replyService.replyList(searchVO.getIdx());
        model.addAttribute("reply",reply);

        return "board/read";
    }
    /**
     * 게시판 수정페이지
     */
    @RequestMapping(value = "/board/update", method = RequestMethod.GET)
    public String update(@ModelAttribute("searchVO") BoardDTO searchVO, @RequestParam("idx") int idx, Model model) throws UnsupportedEncodingException {

        BoardDTO boardContents = boardService.detailBoardList(idx);
        model.addAttribute("boardContents", boardContents);

        searchVO.setQustr();

        return "/board/update";
    }
    @RequestMapping(value = "/board/update_action", method = RequestMethod.POST)
    public String update_action(@ModelAttribute("searchVO") BoardDTO searchVO, HttpServletRequest request, RedirectAttributes redirect , Model model) throws UnsupportedEncodingException {

        try {
            boardService.updateBoard(searchVO);
            redirect.addFlashAttribute("redirect", searchVO.getIdx());
            redirect.addFlashAttribute("msg", "수정이 완료되었습니다.");
        } catch (Exception e) {
            redirect.addFlashAttribute("msg", "오류가 발생되었습니다.");
        }
        searchVO.setQustr();

        return "redirect:/board/read?idx=" + searchVO.getIdx();
    }
    /**
     * 게시판 삭제페이지
     */
    @RequestMapping(value = "/board/delete", method = RequestMethod.GET)
    public String delete(@ModelAttribute("searchVO") BoardDTO searchVO, @RequestParam("idx") int idx, RedirectAttributes redirect , Model model) throws UnsupportedEncodingException {

        try {

            boardService.getBoardDelete(idx);
            redirect.addFlashAttribute("msg", "삭제가 완료되었습니다.");

        } catch (Exception e) {
            redirect.addFlashAttribute("msg", "오류가 발생되었습니다.");

        }
        searchVO.setQustr();

        return "redirect:/board/list";
    }



}
