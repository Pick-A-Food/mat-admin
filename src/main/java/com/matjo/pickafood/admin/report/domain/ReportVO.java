package com.matjo.pickafood.admin.report.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportVO {
    private Integer reportSeq; //문의번호
    private int reportCategory; //카테고리
    private String category; //카테고리 이름
    private String content; //내용
    private String id; //사용자 아이디
    private String reportId; //신고회원 아이디

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate regDate; //신고일
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reportDate; //답변일

    private String reportProcess; //신고결과
    private String answerId; //관리자 아이디
    private Integer reportYn; //접수여부
}
