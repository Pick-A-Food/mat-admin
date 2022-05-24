package com.matjo.pickafood.admin.board.reply.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyVO {

    private Integer replySeq;
    private Integer boardSeq;
    private Integer originReplySeq;
    private Integer ReplySeq;

    private String content;
    private String id;
    private String nickname;
    private String profile;

    @DateTimeFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;

    private String dateStr;
    private double date;

    private int delFlag;
    private int likeCount;
    private String mainImage;

    private String buttonIcon;

}
