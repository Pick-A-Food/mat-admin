package com.matjo.pickafood.admin.admin.mapper;

import com.matjo.pickafood.admin.admin.domain.AdminVO;
import com.matjo.pickafood.admin.admin.domain.Auth;
import org.apache.ibatis.annotations.Insert;

public interface AdminMapper {

    @Insert("insert into admin " +
            "(  id" +
            ",  pw" +
            ",  name" +
            ",  nickname" +
            ",  position" +
            ") " +
            "   values " +
            "(" +
            "   #{id}" +
            ",  #{pw}" +
            ",  #{name}" +
            ",  #{nickname}" +
            ",  #{position} " +
            ")")
    void register(AdminVO adminVO);

    @Insert("insert into auth (id, rolename) values (#{id}, #{rolename})")
    void addAuth(Auth auth);

    AdminVO selectOne(String id);


    void update(AdminVO adminVO);

}
