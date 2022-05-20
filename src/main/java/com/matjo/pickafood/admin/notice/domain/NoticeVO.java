package com.matjo.pickafood.admin.notice.domain;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeVO {

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
