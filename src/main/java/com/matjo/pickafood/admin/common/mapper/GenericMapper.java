package com.matjo.pickafood.admin.common.mapper;

import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.notice.domain.NoticeVO;

import java.util.List;

public interface GenericMapper <E, K>{

    List<E> selectList(ListDTO listDTO);
    int getTotal(ListDTO listDTO);
    void delete(K bno);
    E selectOne(K bno);
    void update(E board);
    void insert(E board);

    int getBoardTotal(ListDTO listDTO);
    
}
