package com.matjo.pickafood.admin.file.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {
    private int fileSeq; //seq(pk 역할)o
    private String uuid; //uuid

    private String boardType; //게시판 종류
    private int boardSeq; //게시판 seq

    private String fileName; //오리지날 파일의 이름
    private String savePath; //파일경로(날짜만)
    private boolean img; //이미지 존재 여부

    public String getLink(){
        return savePath+"/"+uuid+"_"+fileName;
    }
    public String getThumbnail(){
        return savePath+"/s_"+uuid+"_"+fileName;
    }

}
