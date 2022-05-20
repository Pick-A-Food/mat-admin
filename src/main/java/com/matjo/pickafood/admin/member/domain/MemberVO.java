package com.matjo.pickafood.admin.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
  private String id;
  private String pw;
  private String nickname;
}
