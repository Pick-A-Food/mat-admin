package com.matjo.pickafood.admin.food.domain;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyVO {
    private int cateNum;
    private String name;
    private String image;

}
