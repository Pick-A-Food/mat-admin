package com.matjo.pickafood.admin.meal.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MealVO {

  private Integer schoolSeq;
  private String schoolCode;
  private String type;
  private String menu;
  private String ingredient;
  private Integer updateFlag;

  private LocalDateTime serveDate;
  private LocalDateTime updateDate;

}
