package com.matjo.pickafood.admin.admin.domain;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class AdminVO {
    private int inquiry_seq;
    private String name;
    private String position;
    private String nickname;
    private String profile;
    private String id;
    private String pw;

    private List<AdminVO> authList;

}
