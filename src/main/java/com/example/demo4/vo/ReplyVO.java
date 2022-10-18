package com.example.demo4.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ReplyVO {
    private int rno;
    private int idx;
    private String writer;
    private String content;
    private Date regDate;
}
