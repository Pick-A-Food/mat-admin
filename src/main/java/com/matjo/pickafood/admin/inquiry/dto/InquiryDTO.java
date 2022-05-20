package com.matjo.pickafood.admin.inquiry.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class InquiryDTO {
    private Integer inquirySeq; //문의번호
    private String title; //제목
    private String content; //내용
    private String id; //사용자 아이디

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inquiryDate; //문의내용
    
    private String answerContent; //답변내용

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate answerDate; //답변일

    private Integer answerFlag; //관리답변여부
    private String answerId; //관리자 아이디
    private Integer delFlag; //삭제여부
}
