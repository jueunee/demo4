package com.example.demo4.vo;

import lombok.Data;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
public class PageVO {
    private int pageIndex = 1;				    //현재페이지 currentPageNo
    private int pageUnit = 10;				    //페이지갯수 recordCountPerPage
    private int pageSize = 10;	    			//페이지사이즈
    private int firstIndex = 1;		    		//firstIndex - firstPageNoOnPageList
    private int recordCountPerPage = 10;		//recordCountPerPage
    private int totCnt = 0;				      	//총갯수
    private int startDate = 0;			    	//시작데이터
    private int endDate = 0;				    //종료데이터
    private int realEnd = 0;				    //페이징 마지막 숫자
    private boolean prev, next;	    			//이전,다음버튼
    //검색
    private String searchKeyword = "";
    private String queryString = "";

    public void setQueryString() throws UnsupportedEncodingException {
        String qs = "";
        qs += "&searchKeyword=" + URLEncoder.encode(this.searchKeyword,"UTF-8");
        qs += "&pageIndex=" + this.pageIndex;
        this.queryString =qs;
    }
}
