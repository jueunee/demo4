package com.example.demo4.dto;

import com.example.demo4.vo.PageVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO extends PageVO {
    private int idx;

    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private Date updatedate;
    private String qustr;


    @Override
    public String toString() {
        return "BoardDTO{" +
                "idx=" + idx +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", regdate=" + regdate +
                ", updatedate=" + updatedate +
                '}';
    }
    public void setQustr() throws UnsupportedEncodingException {

        String qs = "";
        this.setQueryString();
        qs += this.getQueryString();
        this.qustr = qs;
    }
}
