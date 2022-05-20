package com.matjo.pickafood.admin.board.service;

import com.matjo.pickafood.admin.board.dto.BoardDTO;
import com.matjo.pickafood.admin.board.dto.UploadResultDTO;
import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.common.dto.ListResponseDTO;
import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.common.dto.ListResponseDTO;

import java.util.List;

public interface BoardService {

    ListResponseDTO<BoardDTO> getList(ListDTO listDTO);

    void register(BoardDTO boardDTO);

    BoardDTO getOne(Integer boardSeq);

    void update(BoardDTO boardDTO);

    void remove(Integer boardSeq);

    List<UploadResultDTO> getFiles(Integer boardSeq);
}
