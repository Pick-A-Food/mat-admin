package com.matjo.pickafood.admin.food.dto;

import lombok.Data;

@Data
public class FoodDTO {
    private Integer foodSeq; //pk
    private String name; //이름
    private String company; //회사
    private String companyCategory;
    private String mainImage; //이미지
    private String ingredient; //재료 성분
    private String sameFactory; //같은 공장

    private String image2;
    private String image3;

    private int num;
    private String url;
}
