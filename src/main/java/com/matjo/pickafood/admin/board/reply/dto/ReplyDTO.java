package com.matjo.pickafood.admin.board.reply.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReplyDTO {

    private Integer replySeq;
    private Integer boardSeq;
    private Integer numReplySeq;
    private Integer originReplySeq;

    private String content;
    private String id;
    private String nickname;
    private String profile;

    @DateTimeFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;

    private String dateStr;
    private double date;

    private int delFlag;
    private int likeCount;
    private String mainImage;

    private String root;
    private String buttonIcon;

    public String getRoot() {
        if (originReplySeq == null || originReplySeq == 0) {
            root = "padding-left: 0px";
        } else {
            root = "padding-left: 55px";
        }
        return root;
    }

    public String getButtonIcon() {
        if (originReplySeq == null || originReplySeq == 0) {
            buttonIcon = "<div class=\"secondReplyDIV\"><button class=\"secondReply\">답글쓰기</button></div>";
        } else {
            buttonIcon = "";
        }
        return buttonIcon;
    }

    public String getDateStr() {
        if (date < 1) {
            dateStr = "방금 전";
        } else if (date < 60) {
            dateStr = (int) date + "분 전";
        } else if (date < (60 * 24)) {
            date = date / 60;
            dateStr = (int) date + "시간 전";
        } else if (date < (60 * 168)) {
            date = date / 1440;
            dateStr = (int) date + "일 전";
        } else {
            dateStr = regDate + "";
            dateStr = dateStr.substring(0, 10);
        }
        return dateStr;
    }
}