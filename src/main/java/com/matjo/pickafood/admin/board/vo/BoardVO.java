package com.matjo.pickafood.admin.board.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {

    private Integer boardSeq;
    private Integer boardCategory;
    private String mainImage;
    private String title;
    private String content;
    private String id;
    private String nickname;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
    private int delFlag;
    private int replyCount;
    private int likeCount;
    private int viewsCount;

}
