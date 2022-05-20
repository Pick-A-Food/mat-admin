package com.matjo.pickafood.admin.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
@ToString
public class AdminDTO extends User {

    private int inquirySeq;
    private String name;
    private String position;
    private String nickname;
    private String profile;
    private String id;
    private String pw;

    public AdminDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = username;
        this.pw = password;
    }

}
