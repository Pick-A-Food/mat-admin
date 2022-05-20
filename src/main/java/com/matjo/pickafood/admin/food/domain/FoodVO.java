package com.matjo.pickafood.admin.food.domain;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodVO {

    private Integer foodSeq; //pk
    private String name; //이름
    private String companyCategory;
    private String company; //회사
    private String mainImage; //이미지
    private String ingredient; //재료 성분
    private String sameFactory; //같은 공장

    private String image2;
    private String image3;

}
