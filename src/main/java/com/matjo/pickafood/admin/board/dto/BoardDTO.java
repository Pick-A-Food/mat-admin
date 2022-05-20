package com.matjo.pickafood.admin.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

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

    private List<UploadResultDTO> uploads = new ArrayList<>();

    public String getMain(){
        if(mainImage == null){
            return null;
        }

        int idx = mainImage.indexOf("s_");
        String first = mainImage.substring(0, idx );
        String second = mainImage.substring(idx+2);

        return first+second;
    }
}