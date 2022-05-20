package com.matjo.pickafood.admin.admin.domain;

import lombok.*;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Auth {

    private String id;
    private String rolename;
}
