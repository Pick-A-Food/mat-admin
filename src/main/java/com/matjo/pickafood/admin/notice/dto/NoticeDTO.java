package com.matjo.pickafood.admin.notice.dto;

import com.matjo.pickafood.admin.file.domain.FileVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDTO {

    private String fileSeq ;

    private Integer boardSeq;
    private Integer boardCategory;
    private String mainImage;
    private String title;
    private String content;
    private String id;
    private String nickname;

    private int date;
    private String regDate;
    private String updateDate;

    private int delFlag;
    private int replyCount;
    private int likeCount;
    private int viewsCount;
}
