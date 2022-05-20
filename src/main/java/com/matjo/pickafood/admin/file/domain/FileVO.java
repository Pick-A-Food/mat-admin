package com.matjo.pickafood.admin.file.domain;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FileVO {

    private int fileSeq; //seq(pk 역할)
    private String uuid; //seq (pk 역할)

    private String boardType; //게시판 종류
    private int seq; //게시판 seq

    private String fileName; //오리지날 파일의 이름
    private String savePath; //파일경로(날짜만)
    private boolean img; //이미지 존재 여부

}
